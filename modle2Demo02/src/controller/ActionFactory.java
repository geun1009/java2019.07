package controller;

import java.io.FileInputStream;
import java.util.Properties;

import action.Action;

public class ActionFactory {
	private static ActionFactory factory;
	private Properties prop;
	
	public static synchronized ActionFactory getFactory() {
		if(factory == null) factory =new ActionFactory();
		return factory;
	}
	public ActionFactory() {
		prop = new Properties();
	}
	public Action getAction(String cmd) {
		Action action = null;
		try {
				String path = "C:\\Users\\qudrm\\Desktop\\workspace2\\modle2Demo02\\src\\controller\\classinfo.properties";
				prop.load(new FileInputStream(path));
				System.out.println("key : "+prop.getProperty("index"));
				String rPath = prop.getProperty(cmd);
				System.out.println("kk : "+rPath);
				if(rPath==null) {
					cmd = "index";
					rPath = prop.getProperty(cmd);
				}
				Class<Action> handlerClass =
							(Class<Action>) Class.forName(rPath);
				action = handlerClass.newInstance();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return action;
	}
}
