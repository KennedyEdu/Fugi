import java.sql.ResultSet;

public class AutorInterBO {

    public void ExcluirAutor(AutorVO avo) throws Exception {
        try{
            ResultSet result = AutorDAO.removerById(avo.getIdAutor);
            if (result.next())
            {
            } else{
                throw new Exception("Autor não existente, não possivel excluir");
            }
        } catch (SQLException exc){
            throw new Exception(exc.getMessage());
        }
    }

    public void EditarAutor(AutorVO avo) throws Exception {
        try{
            ResultSet result = AutorDAO.editar(avo);
            if (result.next())
            {
            } else{
                throw new Exception("Autor não existente, não possivel editar");
            }
        } catch (SQLException exc){
            throw new Exception(exc.getMessage());
        }
    }
   
    public List<AutorVO> ListarAutores() throws Exception {
        List<AutorVO>  list = new ArrayList<AutorVO>();
        try{            
            list = AutorDAO.listar();
        } catch (SQLException exc){
            throw new Exception(exc.getMessage());
        }
        return list;
    }
}
