package oop.interfaces;

import database.MySQL_Security;
import oop.objects.Access;

public interface Login {

	public default void inputPassword(char password[]) {
		Access access = MySQL_Security.getAccess(password);
		onInputPassword(access);
	}
	public abstract void onInputPassword(Access access);
}
