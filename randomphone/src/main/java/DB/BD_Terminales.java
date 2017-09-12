package DB;



import java.io.Serializable;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import DB.Terminal;

public class BD_Terminales implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2320075997561361579L;
	public BD_Principal bD_Principal_terminales;
	public Terminal[] terminal = new Terminal[0];


	public boolean altaTerminal(Terminal[] terminales, int facturaId) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {

			Factura factura = FacturaDAO.getFacturaByORMID(facturaId);
			for (Terminal terminal : terminales)
				factura.terminal.add(terminal);

			FacturaDAO.save(factura);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return false;
		}

		return true;
	}

	public boolean modificarTerminal(Terminal[] terminales, int facturaId) throws PersistentException {
		PersistentTransaction t = ProyectoFinalPersistentManager.instance().getSession().beginTransaction();
		try {
			Factura factura = FacturaDAO.getFacturaByORMID(facturaId);
			Terminal[] iniciales = factura.terminal.toArray();
			for (Terminal terminal : iniciales)
				TerminalDAO.deleteAndDissociate(terminal);
			factura.terminal.clear();
			System.out.println("Limpio lista de terminales");
			if (terminales.length != 0) {
				for (Terminal terminal : terminales) {
					factura.terminal.add(terminal);
					System.out.println("Añado terminal: " + terminal.getTipo());
				}
				System.out.println(factura.terminal.size());
				FacturaDAO.save(factura);
				ClienteDAO.save(factura.getCliente());
				t.commit();
			}
			return true;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			t.rollback();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}
}