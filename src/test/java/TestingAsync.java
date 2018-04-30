import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import http.requests.AsyncHttpRequest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.JsonUtils;
import utils.WebPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TestingAsync {

    AsyncHttpRequest asyncHttpRequest;

    @BeforeClass
    public void setup() {
        this.asyncHttpRequest = new AsyncHttpRequest();
        Unirest.setDefaultHeader("Content-Type", "application/json");
    }

    @Test
    public void testGetAsync() {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("link", "https://www.mfs.com/en-us/");

        Future<HttpResponse<JsonNode>> future = asyncHttpRequest.getJsonFuture("http://localhost:4001/api/webPage", null, params);

        try {
            HttpResponse<JsonNode> page = future.get();

            Assert.assertTrue(page.getHeaders().size() >= 1);
            Assert.assertNotNull(page.getBody());
            Assert.assertEquals(page.getStatus(), 200);

            WebPage webPage = JsonUtils.parse(page.getBody().toString(), WebPage.class);

            Assert.assertEquals(webPage.getTitle(), "Massachusetts Financial Services: Welcome | MFS");
            Assert.assertNotNull(webPage.getLinksFromPage());

        } catch(ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testPostAsync() {

        WebPage body = new WebPage("http://corpandrew.com", "Andrew Corp's Portfolio");

        Future<HttpResponse<JsonNode>> future = asyncHttpRequest.postJsonFuture("http://localhost:4001/api/webPage", null, body);

        try {
            HttpResponse<JsonNode> page = future.get();

            Assert.assertTrue(page.getHeaders().size() >= 1);
            Assert.assertNotNull(page.getBody());
            Assert.assertEquals(page.getStatus(), 200);

            WebPage webPage = JsonUtils.parse(page.getBody().toString(), WebPage.class);

            Assert.assertEquals(webPage.getTitle(), "Andrew Corp's Portfolio");
            Assert.assertTrue(webPage.getLinksFromPage().size() == 0);

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test(dependsOnMethods = "testPostAsync")
    public void testDeleteAsync() {

        WebPage body = new WebPage("http://corpandrew.com", "Andrew Corp's Portfolio");

        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("link", "http://corpandrew.com");

        Future<HttpResponse<JsonNode>> future = asyncHttpRequest.deleteJsonFuture("http://localhost:4001/api/webPage", null, parameters);

        try {
            HttpResponse<JsonNode> page = future.get();

            Assert.assertTrue(page.getHeaders().size() >= 1);
            Assert.assertNotNull(page.getBody());
            Assert.assertEquals(page.getStatus(), 200);

            WebPage webPage = JsonUtils.parse(page.getBody().toString(), WebPage.class);

            Assert.assertNull(webPage.getTitle());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public void shutdown() {
        try {
            Unirest.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
