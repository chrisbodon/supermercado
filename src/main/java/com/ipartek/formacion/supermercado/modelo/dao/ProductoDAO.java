package com.ipartek.formacion.supermercado.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.supermercado.modelo.pojo.Producto;

public class ProductoDAO implements IDAO<Producto> {
	
	private static ProductoDAO INSTANCE;
	private ArrayList<Producto> registros;
	private int indice = 1;
	
	
	private ProductoDAO() {		
		super();
		
		registros = new ArrayList<Producto>();
		
		
		Producto p = new Producto();
		p.setId(1);
		p.setNombre("Loctite");
		p.setPrecio(100f);
		p.setImagen("https://www.bricolemar.com/23057-thickbox_default/loctite-super-glue-3-20gr-profesional-henkel.jpg");
		p.setDescripcion("Adhesivo potente");
		p.setDescuento(20);
		
		Producto p1 = new Producto();
		p1.setId(2);
		p1.setNombre("Lays campesinas");
		p1.setPrecio(1.40f);
		p1.setImagen("https://images-na.ssl-images-amazon.com/images/I/81dkp3s9ZvL._SX679_.jpg");
		p1.setDescripcion("Patatas campesinas lays");
		p1.setDescuento(10);
		
		Producto p2 = new Producto();
		p2.setId(3);
		p2.setNombre("Jack Daniels");
		p2.setPrecio(16.40f);
		p2.setImagen("https://d1osgs5rdqb11o.cloudfront.net/products/main/317/317.thm350.jpg");
		p2.setDescripcion("Botella whisky 70cl");
		p2.setDescuento(7);
		
		Producto p3 = new Producto();
		p3.setId(4);
		p3.setNombre("Vodka negro");
		p3.setPrecio(12.20f);
		p3.setImagen("https://www.bodecall.com/images/stories/virtuemart/product/eristoff_black.png");
		p3.setDescripcion("Vozka eristoff negro, botella 70cl");
		p3.setDescuento(20);
		
		Producto p4 = new Producto();
		p4.setId(5);
		p4.setNombre("Jumpers mantequilla");
		p4.setPrecio(0.40f);
		p4.setImagen("https://www.bolinchelidrinkstore.com/1618-large_default/jumpers-de-mantequilla-42-grs-c30.jpg");
		p4.setDescripcion("snacks de mantequilla, 42gr");
		p4.setDescuento(10);
		
		Producto p5 = new Producto();
		p5.setId(6);
		p5.setNombre("Pipas tijuana");
		p5.setPrecio(0.45f);
		p5.setImagen("https://www.grefusa.com/wp-content/uploads/2017/05/PipasG_Tijuana.png");
		p5.setDescripcion("Pipas con sabor a tijuana");
		p5.setDescuento(0);
		
		Producto p6 = new Producto();
		p6.setId(7);
		p6.setNombre("Papa deltas");
		p6.setPrecio(0.35f);
		p6.setImagen("https://images-na.ssl-images-amazon.com/images/I/81Jc5-yC4ZL._SY445_.jpg");
		p6.setDescripcion("Snacks tipicos");
		p6.setDescuento(30);
		
		Producto p7 = new Producto();
		p7.setId(8);
		p7.setNombre("Ketchup heinz");
		p7.setPrecio(2.40f);
		p7.setImagen("https://www.tuclubdecompras.es/contenidos/articulos/25/12602-001-1-2.jpg");
		p7.setDescripcion("Ketchup de la mejor calidad");
		p7.setDescuento(20);
		
		Producto p8 = new Producto();
		p8.setId(9);
		p8.setNombre("Moet Chandon");
		p8.setPrecio(40.50f);
		p8.setImagen("https://images-na.ssl-images-amazon.com/images/I/715UyJpBfoL._SX569_.jpg");
		p8.setDescripcion("Champagne de calidad");
		p8.setDescuento(10);
		
		Producto p9 = new Producto();
		p9.setId(10);
		p9.setNombre("Tinto crianza LAN");
		p9.setPrecio(7.50f);
		p9.setImagen("https://compraralproductor.com/673-large_default/vino-lan-crianza-2016.jpg");
		p9.setDescripcion("Vino Riojano 2016");
		p9.setDescuento(20);
		
		registros.add(p);
		registros.add(p1);
		registros.add(p2);
		registros.add(p3);
		registros.add(p4);
		registros.add(p5);
		registros.add(p6);
		registros.add(p7);
		registros.add(p8);
		registros.add(p9);
		
	}
	
	public static synchronized ProductoDAO getInstance() {
		
		if ( INSTANCE == null ) {
			INSTANCE = new ProductoDAO(); 
		}
		
		return INSTANCE;
	}
	
	

	@Override
	public List<Producto> getAll() {		
		return registros;
	}

	@Override
	public Producto getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto delete(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto update(int id, Producto pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto create(Producto pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
