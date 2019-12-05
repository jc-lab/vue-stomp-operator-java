package kr.jclab.spring.vuestompoperator;

import java.util.*;

public class VueStompResponseEntity<T> {
    private final int status;
    private final Map<String, String> headers;
    private final T body;

    public VueStompResponseEntity(int status, Map<String, String> headers, T body) {
        this.body = body;
        this.headers = headers;
        this.status = status;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder notFound() {
        return status(404);
    }

    public static <T> VueStompResponseEntity<T> of(Optional<T> body) {
        return body.map(VueStompResponseEntity::ok).orElse(notFound().build());
    }

    public static <T> VueStompResponseEntity<T> ok(T body) {
        return new VueStompResponseEntity<T>(200, null, body);
    }

    public static Builder status(int status) {
        return new Builder()
                .status(status);
    }

    public int getStatus() {
        return status;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public T getBody() {
        return body;
    }

    public static class Builder {
        private int status = 200;
        private Map<String, String> headers = new HashMap<>();

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder header(String name, String value) {
            this.headers.put(name, value);
            return this;
        }

        public <T> VueStompResponseEntity<T> body(T body) {
            return new VueStompResponseEntity<T>(this.status, this.headers, body);
        }

        public <T> VueStompResponseEntity<T> build() {
            return new VueStompResponseEntity<T>(this.status, this.headers, null);
        }
    }
}
