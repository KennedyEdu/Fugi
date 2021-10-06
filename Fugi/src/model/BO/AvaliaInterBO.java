import java.sql.ResultSet;

public class AvaliaInterBO {
    
    public void ExcluirAvalia(AvaliaObraVO avo) throws Exception {
        try{
            ResultSet result =  avaliaObraDAO.removerById(avo.getIdAvalia);
            if (result.next())
            {
            } else{
                throw new Exception("Avaliação não existente, não possivel excluir");
            }
        } catch (SQLException exc){
            throw new Exception(exc.getMessage());
        }
    }

    public void EditarAvalia(AvaliaObraVO avo) throws Exception {
        try{
            ResultSet result =  avaliaObraDAO.editar(avo);
            if (result.next())
            {
            } else{
                throw new Exception("Avaliação não existente, não possivel editar");
            }
        } catch (SQLException exc){
            throw new Exception(exc.getMessage());
        }
    }
   
    public List<AvaliaObraVO> ListarAvalia() throws Exception {
        List<AvaliaObraVO>  list = new ArrayList<AvaliaObraVO>();
        try{            
            list =  avaliaObraDAO.listar();
        } catch (SQLException exc){
            throw new Exception(exc.getMessage());
        }
        return list;
    }
}
