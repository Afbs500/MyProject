package controle;

import java.util.List;

public interface RepositoryGeneric<T>{

	
	public void Insert(T obj);
	public void Update(T obj, int id);
	public void Delete(int Id);
	List<T> FindAll();
	T FindById(int Id);
	
	
}
