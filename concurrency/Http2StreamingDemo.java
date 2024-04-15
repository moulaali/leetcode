import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.Arrays;
import java.util.List;

/**
 * Demo http2 request/response multiplexing with streams
 */
public class Http2StreamingDemo {

    public static void main(String[] args) throws InterruptedException {
        OkHttpClient client = new OkHttpClient.Builder().build();

        // URLs for streaming requests
        List<String> urls = Arrays.asList(
                "https://www.wikipedia.org",
                "https://www.nytimes.com",
                "https://www.reddit.com",
                "https://www.github.com",
                "https://www.stackoverflow.com",
                "https://www.netflix.com",
                "https://www.spotify.com",
                "https://www.etsy.com",
                "https://www.bbc.co.uk",
                "https://www.weather.com"
        );

        // Try couple of times
        requestStreaming(urls, client);
        Thread.sleep(3000);
        requestStreaming(urls, client);
    }

    private static void requestStreaming(List<String> urls, OkHttpClient client) {
        System.out.println("-------");

        // Send requests asynchronously
        int i = 1;
        for (String url : urls) {
            Request request = new Request.Builder().url(url).tag(i++).build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    System.out.println("Tag: " + call.request().tag()+ " : Received response for: "
                            + call.request().url() + " : " + response.code());
                    response.close();
                }

                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
