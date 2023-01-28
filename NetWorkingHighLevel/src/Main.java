import javax.print.attribute.URISyntax;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        try {
            URI baseUri = new URI("http://usarname:password@myserver.com.5000");
            URI uri = new URI("/catalogue/phones?os=android#samsung");
            URI ur2 = new URI("/catalogue/tvs?manufacturate=samsung");
            URI ur3 = new URI("/catalogue/cars?os=android#samsung");

            URI resolvedUri = baseUri.resolve(uri);
            URI resolvedUr2 = baseUri.resolve(ur2);
            URI resolvedUr3 = baseUri.resolve(ur2);



            URL url =resolvedUri.toURL();
            System.out.println("URL = "+ url);

            URL url2 =resolvedUri.toURL();
            System.out.println("URL = "+ url2);

            URL url3 =resolvedUri.toURL();
            System.out.println("URL = "+ url3);

        }catch (URISyntaxException e){
            System.err.println(e.getMessage());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}