package com.example.IndividualTrackProject.Config;


import com.example.IndividualTrackProject.Filter.JWTAuthenticationFilter;
import com.example.IndividualTrackProject.Filter.JWTAuthorizationFilter;
import com.example.IndividualTrackProject.Service.AuthenticationUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationUserDetailService authenticationUserDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        corsConfiguration.setAllowedOrigins(List.of("http://localhost:3000"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PUT","OPTIONS","PATCH", "DELETE"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setExposedHeaders(List.of("Authorization"));

        http.headers().frameOptions().disable();

       http.cors().configurationSource(request -> corsConfiguration).and().csrf().disable().authorizeRequests()
               .antMatchers(HttpMethod.POST, AuthenticationConfigConstants.SIGN_UP_URL).permitAll()
                .antMatchers("/h2-ui").permitAll()
                .antMatchers("/h2-ui/**").permitAll()
               .antMatchers("/feedbacks/**").permitAll()
               .antMatchers("/landlords/newLandlord").permitAll()
               .antMatchers("/landlords/landlord/**").permitAll()
                .antMatchers("/landlords/*").permitAll()
               .antMatchers("/houses/newHouse").permitAll()
               .antMatchers("/houses/houseLandlord/*").permitAll()
               .antMatchers("/houses/leave/*").permitAll()
               .antMatchers("/houses/booked/houseLandlord/*").permitAll()
               .antMatchers("/houses/*").permitAll()
               .antMatchers("/bookings/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationUserDetailService).passwordEncoder(bCryptPasswordEncoder);
    }
}
