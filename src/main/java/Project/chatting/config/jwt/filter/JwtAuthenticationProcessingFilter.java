package Project.chatting.config.jwt.filter;

/**
 * https://ttl-blog.tistory.com/273 <-- 자세한 작동원리
 * 클라이언트가 헤더에 JWT 토큰을 담아서 "/login" URL 이외의 요청을 보냈을 시,
 * 해당 토큰들의 유효성을 검사하여 인증 처리, 인증 실패, 토큰 재발급 등을 수행하는 역할의 필터.
 * 이 인증 필터를 이해하기 위해서는 , JWT 인증 로직을 이해해야한다.
 */
public class JwtAuthenticationProcessingFilter {

}
