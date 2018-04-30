package http.requests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import java.util.Map;
import java.util.concurrent.Future;

public class AsyncHttpRequest {

    /**
     *
     * @param url        url to call API
     * @param parameters map of parameters to send
     * @return Future HTTP Response JsonNode
     */
    public Future<HttpResponse<JsonNode>> getJsonFuture(String url, Map<String, Object> parameters) {
        return Unirest.get(url).queryString(parameters).asJsonAsync();
    }

    /**
     *
     * @param url        url to call API
     * @return Future HTTP Response JsonNode
     */
    public Future<HttpResponse<JsonNode>> getJsonFutureRouteParam(String url, String routeParamName, String routeParamValue) {
        return Unirest.get(url).routeParam(routeParamName, routeParamValue).asJsonAsync();
    }

    /**
     * @param url        url to call API
     * @param headers    map of headers to send
     * @param parameters map of parameters to send
     * @return Future HTTP Response JsonNode
     */
    public Future<HttpResponse<JsonNode>> getJsonFuture(String url, Map<String, String> headers, Map<String, Object> parameters) {
        return Unirest.get(url).headers(headers).queryString(parameters).asJsonAsync();
    }

    /**
     * @param url        url to call API
     * @param headers    map of headers to send (key,val)
     * @param body       Object where toString must be overrode to convert and put as body.
     * @return Future HTTP Response JsonNode
     */
    public Future<HttpResponse<JsonNode>> postJsonFuture(String url, Map<String, String> headers, Object body) {
        return Unirest.post(url).headers(headers).body(body.toString()).asJsonAsync();
    }

    /**
     * @param url        url to call API
     * @param headers    map of headers to send (key,val)
     * @param parameters map of parameters(fields) to send (key,val)
     * @return Future HTTP Response JsonNode
     */
    public Future<HttpResponse<JsonNode>> putJsonFuture(String url, Map<String, String> headers, Map<String, Object> parameters) {
        return Unirest.put(url).headers(headers).fields(parameters).asJsonAsync();
    }

    /**
     * @param url        url to call API
     * @param headers    map of headers to send (key,val)
     * @param parameters map of parameters(fields) to send (key,val)
     * @return Future HTTP Response JsonNode
     */
    public Future<HttpResponse<JsonNode>> deleteJsonFuture(String url, Map<String, String> headers, Map<String, Object> parameters) {
        return Unirest.delete(url).headers(headers).queryString(parameters).asJsonAsync();
    }


}
