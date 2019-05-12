package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@ComponentScan(basePackages = "com.example.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  public void configure(WebSecurity web) throws Exception {

    web.ignoring()
        .mvcMatchers("/css/**")
        .mvcMatchers("/js/**")
        .mvcMatchers("/fonts/**");
  }


    /**
     *
     * @param http
     * @throws Exception
     * @see <a href="Spring SecurityガイドFormログイン属性">
     *     https://docs.spring.io/spring-security/site/docs/5.1.5.RELEASE/reference/htmlsingle/#nsa-form-login-attributes</a>
     */
  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()
        // /manager配下はADMIN権限のみ(自動でROLE_が付加されROLE_ADMIN)
        .mvcMatchers("/manager/**")
        .hasRole("ADMIN")
        // 認証していないリクエストは不許可
        .anyRequest()
        .authenticated();

    http.formLogin().loginPage("/loginForm").permitAll();
    // フォーム認証
    http.formLogin()
        // 認証パス
        .loginProcessingUrl("/login")
        // ログインフォーム表示用のパス設定
        .loginPage("/loginForm")
        // 認証失敗時のパス
        .failureUrl("/loginForm?error")
        // 認証成功時のパス
        .defaultSuccessUrl("/", true)
        // ユーザ名のリクエストパラメータ
        .usernameParameter("id")
        // パスワードのリクエストパラメータ
        .passwordParameter("password");

    http.logout()
        // ログアウトURL
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout/**"))
        // ログアウト後の遷移先
        .logoutSuccessUrl("/loginForm");
    http.headers().cacheControl().disable();
  }

  /** パスワードの暗号化方式 */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
