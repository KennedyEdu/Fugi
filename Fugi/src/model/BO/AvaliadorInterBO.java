import java.sql.ResultSet;

public class AvaliadorInterBO {
    
    public void ExcluirAvaliador(AvaliadorVO avo) throws Exception {
        try{
            ResultSet result = AvaliadorDAO.removerById(avo.getIdAvaliador);
            if (result.next())
            {
            } else{
                throw new Exception("Avaliador não existente, não possivel excluir");
            }
        } catch (SQLException exc){
            throw new Exception(exc.getMessage());
        }
    }

    public void EditarAvaliador(AvaliadorVO avo) throws Exception {
        try{
            ResultSet result = AvaliadorDAO.editar(avo);
            if (result.next())
            {
            } else{
                throw new Exception("Avaliador não existente, não possivel editar");
            }
        } catch (SQLException exc){
            throw new Exception(exc.getMessage());
        }
    }
   
    public List<AvaliadorVO> ListarAvaliadores() throws Exception {
        List<AvaliadorVO>  list = new ArrayList<AvaliadorVO>();
        try{            
            list = AvaliadorDAO.listar();
        } catch (SQLException exc){
            throw new Exception(exc.getMessage());
        }
        return list;
    }
}
