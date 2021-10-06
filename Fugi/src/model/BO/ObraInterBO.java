import java.sql.ResultSet;

public class ObraInterBO {
    public void ExcluirObra(ObraVO avo) throws Exception {
        try{
            ResultSet result =  ObraDAO.removerById(avo.getIdObra);
            if (result.next())
            {
            } else{
                throw new Exception("Obra não existente, não possivel excluir");
            }
        } catch (SQLException exc){
            throw new Exception(exc.getMessage());
        }
    }

    public void EditarObra(ObraVO avo) throws Exception {
        try{
            ResultSet result =  ObraDAO.editar(avo);
            if (result.next())
            {
            } else{
                throw new Exception("Obra não existente, não possivel editar");
            }
        } catch (SQLException exc){
            throw new Exception(exc.getMessage());
        }
    }
   
    public List<ObraVO> ListarObras() throws Exception {
        List<ObraVO>  list = new ArrayList<ObraVO>();
        try{            
            list =  ObraDAO.listar();
        } catch (SQLException exc){
            throw new Exception(exc.getMessage());
        }
        return list;
    }
}
