package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import Model.Producto;

@Repository
public class Producto_DAO_Imp  implements Producto_DAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveProducto(Producto producto) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().save(producto);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Producto> getProductos() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Producto> query=currentSession.createQuery("from Producto", Producto.class);
		List<Producto> list=query.getResultList();
		return list;
	}

	@Override
	public boolean deleteProducto(Producto producto) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().delete(producto);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override  
    public List<Producto> getProductoByID(Producto producto) {  
        Session currentSession = sessionFactory.getCurrentSession();  
        Query<Producto> query=currentSession.createQuery("from Producto where id_producto=:id_producto", Producto.class);  
        query.setParameter("id_producto", producto.getId_producto());  
        List<Producto> list=query.getResultList();  
        return list;  
    }  

	@Override
	public boolean updateProducto(Producto producto) {
		boolean status=false;
		try {
			sessionFactory.getCurrentSession().update(producto);
			status=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
}
