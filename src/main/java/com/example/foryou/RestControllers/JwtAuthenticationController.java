package com.example.foryou.RestControllers;


import com.example.foryou.Config.JwtTokenUtil;
import com.example.foryou.DAO.Entities.Role;
import com.example.foryou.DAO.Entities.RoleType;
import com.example.foryou.DAO.Entities.User;
import com.example.foryou.DAO.Repositories.RoleRepository;
import com.example.foryou.Model.JwtRequest;
import com.example.foryou.Services.Classes.UserService;
import com.example.foryou.Services.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        System.out.println(authenticationRequest.getUsername() + authenticationRequest.getPassword());
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        System.out.println("helloo");
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        User user = userService.selectByUsername(authenticationRequest.getUsername());
        System.out.println(user.getRole().getRoleType().name());
        if(user == null){
            System.out.println("null user");
        }
        final String token = jwtTokenUtil.generateToken(userDetails);
        HashMap<String, String> response = new HashMap<>();

        response.put("token", token);
        response.put("role", user.getRole().getRoleType().name());
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/register/{roleValue}", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody User user, @PathVariable("roleValue") String roleValue) throws Exception {
        System.out.println(RoleType.valueOf(roleValue).toString());
        Role role = this.roleRepository.findByRoleType(RoleType.valueOf(roleValue)).get(0);
        user.setRole(role);
        return ResponseEntity.ok(userService.add(user));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}