package controle;

import java.util.List;

public interface RepostioryGeneric<T>{

	
	public void Insert(T obj);
	public void Update(T obj);
	public void Delete(int Id);
	List<T> FindAll();
	T FindById(int Id);
	
	
}
