/**
 * class to create a social network of nodes
 */
package SocialNetwork;

import java.util.HashMap;

public class Graph implements Node {

	HashMap<String, Entity> map = new HashMap<String, Entity>();

	/**
	 * constructor to get all details of user
	 * 
	 * @param file
	 */
	public Graph(String file) {
		String stringOutput[] = file.split("\n");
		Entity entity;
		String str[] = {};
		for (int index = 0; index < stringOutput.length; index++) {
			str = stringOutput[index].split(",");
			if (str[2].equals("user")) {
				entity = new User();
				entity.setType(str[2]);
			} else {
				entity = new Organization();
				entity.setType(str[2]);
			}
			entity.setId(str[0]);
			entity.setName(str[1]);
			map.put(str[0], entity);
		}
	}

	/**
	 * create a node to add user
	 */
	public void createNode(User obj, String name, String id) {
		obj.setType("user");
		obj.setName(name);
		obj.setId(id);
		addNode(obj);
	}

	/**
	 * create a node to add organization
	 */
	public void createNode(Organization obj, String name, String id) {
		obj.setType("organization");
		obj.setName(name);
		obj.setId(id);
		addNode(obj);
	}

	/**
	 * add node to social network
	 */
	public void addNode(Entity obj) {
		map.put(obj.getId(), obj);
	}

	/**
	 * check if node exist in network
	 */
	public boolean checkNode(String id) {

		if (map.containsKey(id)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * edit details of node
	 */
	public void editNode(String id, String name) {
		map.get(id).setName(name);
	}

	/**
	 * delete node from network
	 */
	public void deleteNode(String id) {
		map.remove(id);
		System.out.println("Profile has been deleted");
	}

	/**
	 * 
	 * @param id
	 * @return name of user if exist
	 */
	public String printName(String id) {
		if (map.containsKey(id)) {
			return map.get(id).getName();
		} else {
			return "Profile does not exist";
		}
	}

}
