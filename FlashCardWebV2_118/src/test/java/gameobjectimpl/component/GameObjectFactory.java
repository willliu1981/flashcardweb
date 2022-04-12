package gameobjectimpl.component;

public class GameObjectFactory {

	
	public static GameObject createGameObject(String name) {
		GameObject go=new GameObject();
		go.setName(name);
		go.setOwner(name);
		
		
		
		return go;
	}
}
