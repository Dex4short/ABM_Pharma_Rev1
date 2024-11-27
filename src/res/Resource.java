package res;

import java.net.URL;

public class Resource{

	public static URL get(String file_name) {
		return new Resource().getClass().getResource(file_name);
	}
}
