package com.Security.SBandJwt.config;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class StudentConfig {


    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChai(HttpSecurity http, HttpSession httpSession) throws Exception {

        return http
                //http
                .csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                //.formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
//       1 http.csrf(customizer->customizer.disable());//disable cef
//        http.authorizeHttpRequests(request->request.anyRequest().authenticated()); //authorize rules for incoming request
//        http.formLogin(Customizer.withDefaults());//for form in page
//        http.httpBasic(Customizer.withDefaults());//for api
//        http.sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//1 same code
//        Customizer<CsrfConfigurer<HttpSecurity>> customize=new Customizer<CsrfConfigurer<HttpSecurity>>() {
//    @Override
//    public void customize(CsrfConfigurer<HttpSecurity>  customizer) {
//        customizer.disable();
//    }
//} ;

//http.csrf(customize);


        // return http.build();


        // }

//    @Bean  inbuilt which we won't use
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user1= User
//                .withDefaultPasswordEncoder()
//                .username("manish")
//                .password("1234")
//
//                .build();
//
//        return new InMemoryUserDetailsManager();

    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
         DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
       //  provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());//for database
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));//for database

        provider.setUserDetailsService(userDetailsService);//own class
         return provider;
    }

}

