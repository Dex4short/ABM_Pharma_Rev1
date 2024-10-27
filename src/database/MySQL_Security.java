package database;

import oop.enums.SecurityRole;
import oop.objects.Access;

public class MySQL_Security {

	public static Access getAccess(char password[]) {
		String pass = "";
		for(char p: password) {
			pass += p;
		}

		Object obj[][] = MySQL.select(new String[] {"sec_id", "role"}, " security ", " where password='" + pass + "' ");
		
		if(obj.length > 0) {
			return new Access((int)obj[0][0], SecurityRole.valueOf((String)obj[0][1]));
		}
		else {
			return null;
		}
	}
}
