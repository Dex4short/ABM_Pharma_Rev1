package res;

import java.net.URL;

public class Resource{

	public URL get(String file_name) {
		return getClass().getResource(file_name);
	}
}
