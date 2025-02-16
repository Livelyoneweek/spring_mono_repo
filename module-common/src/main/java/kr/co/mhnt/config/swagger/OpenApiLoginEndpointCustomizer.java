package kr.co.mhnt.config.swagger;

import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.media.*;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.lang.reflect.Field;

@Slf4j
public class OpenApiLoginEndpointCustomizer<JSON_FILTER extends UsernamePasswordAuthenticationFilter> {

    public OpenApiCustomizer loginEndpointCustomizer(JSON_FILTER filter, String tagName) {
        return openAPI -> {
            Operation operation = new Operation();

            operation.requestBody(getLoginRequestBody(filter));
            operation.responses(getLoginApiResponses());
            operation.addTagsItem(tagName);
            operation.summary("로그인");
            operation.description("사용자 계정의 인증을 처리한다.");

            PathItem pathItem = new PathItem().post(operation);
            try {
                openAPI.getPaths().addPathItem(getLoginPath(filter), pathItem);
            } catch (Exception ignored) {
                // Exception escaped
                log.trace(ignored.getMessage());
            }
        };
    }

    private String getLoginPath(JSON_FILTER filter) throws Exception {
        Field requestMatcherField = AbstractAuthenticationProcessingFilter.class.getDeclaredField("requiresAuthenticationRequestMatcher");
        requestMatcherField.setAccessible(true);
        AntPathRequestMatcher requestMatcher = (AntPathRequestMatcher) requestMatcherField.get(filter);
        String loginPath = requestMatcher.getPattern();
        requestMatcherField.setAccessible(false);
        return loginPath;
    }

    private RequestBody getLoginRequestBody(JSON_FILTER filter) {
        Schema<?> schema = new ObjectSchema();
        schema.addProperty(filter.getUsernameParameter(), new StringSchema()._default(filter.getUsernameParameter()));
        schema.addProperty(filter.getPasswordParameter(), new StringSchema()._default(filter.getPasswordParameter()));

        return new RequestBody().content(new Content().addMediaType(
                org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
                new MediaType().schema(schema)
        ));
    }

    private ApiResponses getLoginApiResponses() {
        ApiResponses apiResponses = new ApiResponses();
        apiResponses.addApiResponse(
                String.valueOf(HttpStatus.OK.value()),
                new ApiResponse().description(HttpStatus.OK.getReasonPhrase())
        );
        apiResponses.addApiResponse(
                String.valueOf(HttpStatus.FORBIDDEN.value()),
                new ApiResponse().description(HttpStatus.FORBIDDEN.getReasonPhrase())
        );

        return apiResponses;
    }
}
