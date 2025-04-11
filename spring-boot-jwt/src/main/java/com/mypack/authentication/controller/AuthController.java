
package com.mypack.authentication.controller;

import com.mypack.authentication.controller.dto.ApiErrorResponse;
import com.mypack.authentication.controller.dto.LoginAttemptResponse;
import com.mypack.authentication.controller.dto.LoginRequest;
import com.mypack.authentication.controller.dto.LoginResponse;
import com.mypack.authentication.controller.dto.SignupRequest;
import com.mypack.authentication.domain.LoginAttempt;
import com.mypack.authentication.helper.JwtHelper;
import com.mypack.authentication.service.LoginService;
import com.mypack.authentication.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {

  private final AuthenticationManager authenticationManager;
  private final UserService userService;
  private final LoginService loginService;

  public AuthController(AuthenticationManager authenticationManager, UserService userService, LoginService loginService) {
    this.authenticationManager = authenticationManager;
    this.userService = userService;
    this.loginService = loginService;
  }

  @Operation(summary = "Signup user")
  @ApiResponse(responseCode = "201")
  @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
  @ApiResponse(responseCode = "409", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
  @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
  @PostMapping("/signup")
  public ResponseEntity<String> signup(@Valid @RequestBody SignupRequest requestDto) {
    System.out.println("Sign up started................................");
    userService.signup(requestDto);
    System.out.println("Sign up end................................");
    return ResponseEntity.status(HttpStatus.CREATED).body("Registered successfully.");
  }

  @Operation(summary = "Authenticate user and return token")
  @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = LoginResponse.class)))
  @ApiResponse(responseCode = "401", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
  @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
  @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
  @PostMapping(value = "/login")
  public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
    try {
      System.out.println("Login started....................................");
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
      System.out.println("Login completed..................................");
    } catch (BadCredentialsException e) {
      loginService.addLoginAttempt(request.email(), false);
      throw e;
    }
    System.out.println("Generating JWT Token........................");
    String token = JwtHelper.generateToken(request.email());
    System.out.println("Token generated............................");
    System.out.println("\n" + token + "\n");
    loginService.addLoginAttempt(request.email(), true);
    return ResponseEntity.ok(new LoginResponse(request.email(), token));
  }

  @Operation(summary = "Get recent login attempts")
  @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = LoginResponse.class)))
  @ApiResponse(responseCode = "403", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))//forbidden
  @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = ApiErrorResponse.class)))
  @GetMapping(value = "/loginAttempts")
  public ResponseEntity<List<LoginAttemptResponse>> loginAttempts(@RequestHeader("Authorization") String token) {
    System.out.println("loginAttempts....................................");
    String email = JwtHelper.extractUsername(token.replace("Bearer ", ""));
    List<LoginAttempt> loginAttempts = loginService.findRecentLoginAttempts(email);
    return ResponseEntity.ok(convertToDTOs(loginAttempts));
  }

  private List<LoginAttemptResponse> convertToDTOs(List<LoginAttempt> loginAttempts) {
    return loginAttempts.stream()
        .map(LoginAttemptResponse::convertToDTO)
        .collect(Collectors.toList());
  }
}