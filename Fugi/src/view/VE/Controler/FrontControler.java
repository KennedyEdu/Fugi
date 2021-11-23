package view.VE.Controler;


import java.text.SimpleDateFormat;
import java.util.Date;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.BO.AutorBO;
import model.BO.AvaliaObraBO;
import model.BO.AvaliadorBO;
import model.BO.ObraBO;
import model.BO.AutenticarBO;
import model.VO.AutorVO;
import model.VO.AvaliaObraVO;
import model.VO.AvaliadorVO;
import model.VO.ObraVO;
import model.VO.UsuarioVO;
import view.TelaAdmAutor;
import view.TelaAdmAval;
import view.TelaAdmObra;
import view.TelaAvaliadorAvali;
import view.TelaEscritorAval;

public class FrontControler extends AutenticarBO{
    // login
	@FXML private Label ErroLogin;
    @FXML private TextField Loginusuario;
    @FXML private TextField Loginsenha;
	private static UsuarioVO usuario = new UsuarioVO();
	private static int window = 0;
	
    //generico
	 @FXML private Pane Tela1;
	 @FXML private Pane Tela2;
	 @FXML private Pane Tela3;
	 @FXML private TextField Pesquisa;
	 @FXML private CheckBox obrabox;
	 @FXML private CheckBox nomebox;
	 @FXML private CheckBox autorbox;
	 @FXML private CheckBox titulobox;
	 @FXML private CheckBox databox;
	 @FXML private CheckBox statusbox;
	 @FXML private Label ErroID;
	 
	
    //Adicionar usuario
	  @FXML private TextField NovoEndereço;
	  @FXML private TextField NovoNome;
	  @FXML private TextField NovoCPF;
	  @FXML private TextField NovoEmail;
	  @FXML private TextField NovoSenha;
	 
	//Avaliação
	  @FXML private TextField IdAvaliadorAdicionar;
	  @FXML private TextField IdObraAdicionar;
	  @FXML private TextField IdObraRemover;
	  @FXML private TextField IdAvaliadorRemover;
	  
	//Editar usuario
	  @FXML private TextField EndereçoEditarUsur;
	  @FXML private TextField NomeEditarUsur;
	  @FXML private TextField CPFEditarUsur;
	  @FXML private TextField EmailEditarUsur;
	  @FXML private TextField SenhaEditarUsur;
	  @FXML private TextField IDEditarUsur;
	  
	 //Adicionar Obra
	  @FXML private TextField NomeObra;
	  @FXML private TextField GeneroObra;
    
	 //Avaliação de obra
	  @FXML private TextField IDobraAvaliar;
	  @FXML private CheckBox aceitobox;
	  @FXML private CheckBox negadobox;
	  @FXML private Label ErroOpções;
	  
	 //Excluir
	  @FXML private TextField IDExcluir;
	  @FXML private Label ErroIDExcluir;
	  @FXML private Label ErroIDAvaliação;
	  
	  //Pesquisar
	  @FXML private TableView<AvaliaObraVO> AvaliaçõesList;
	  @FXML private TableView<ObraVO> ObrasList;
	  @FXML private TableView<ObraVO> ObrasListBasic;
	  @FXML private TableView<AutorVO> AutoresList;
	  @FXML private TableView<AvaliadorVO> AvaliadoresList;
	  @FXML private TableColumn<ObraVO, String> Titulocl;
	  @FXML private TableColumn<ObraVO, String> Generocl;
	  @FXML private TableColumn<ObraVO, String> Datacl;
	  @FXML private TableColumn<ObraVO, String> Statuscl;
	  @FXML private TableColumn<AutorVO, Long> IdAutorcl;
	  @FXML private TableColumn<AvaliadorVO, Long> IdAvaliadorcl;
	  @FXML private TableColumn<UsuarioVO, String> CPFcl;
	  @FXML private TableColumn<UsuarioVO, String> Emailcl;
	  @FXML private TableColumn<UsuarioVO, String> Senhacl;
	  @FXML private TableColumn<UsuarioVO, String> Nomecl;
	  @FXML private TableColumn<UsuarioVO, String> Endereçocl;
	  @FXML private TableColumn<ObraVO, Long> IddeObracl;
	  @FXML private TableColumn<ObraVO, Long> IdObracl;
	  @FXML private Label errocaixa;
	   
	  
	  
	  public void Verificar (ActionEvent event) throws Exception{
		UsuarioVO vo = new UsuarioVO();
		vo.setNome(Loginusuario.getText());
		vo.setSenha(Loginsenha.getText());
		try {
		if(autenticar(vo))
		{
			ErroLogin.setVisible(false);
			FrontControler.usuario = Identificar(vo);
			 switch (usuario.getNivel()){
	            case 0:
	    			TelaEscritorAval tela1 = new TelaEscritorAval();
	    			try
	    			{
	    				tela1.start(new Stage());
	    			} catch (Exception exep) {
		              exep.printStackTrace();
	    			} 
	                break;
	            case 1:
	    			TelaAvaliadorAvali tela3 = new TelaAvaliadorAvali();
	    			try
	    			{
	    				tela3.start(new Stage());
	    			} catch (Exception exep)
	    			 {
			              exep.printStackTrace();
		    			} 
	                break;
	            case 2:
	    			FrontControler.window = 3;
	    			TelaAdmObra tela2 = new TelaAdmObra();
	    			try
	    			{
	    				tela2.start(new Stage());
	    			} catch (Exception exep)
	    			 {
			              exep.printStackTrace();
		    			} 
	                break;
	        }
				Stage stage = (Stage) Loginusuario.getScene().getWindow();
				stage.close();
		} else {
		   ErroLogin.setVisible(true);
	  }
	    } catch (Exception exep)
		 {
            exep.printStackTrace();
			} 
	  }
	  
	public void Clicked1 (ActionEvent event){
		Tela1.setVisible(true);
	}

	public void Cancel1 (ActionEvent event){
		Tela1.setVisible(false);
	}
	
	public void Clicked2 (ActionEvent event){
		Tela2.setVisible(true);
	}

	public void Cancel2 (ActionEvent event){
		Tela2.setVisible(false);
	}
	
	public void Clicked3 (ActionEvent event){
		Tela3.setVisible(true);
	}

	public void Cancel3 (ActionEvent event){
		Tela3.setVisible(false);
	}
	
	public void Autortrue (ActionEvent event)
	{
		titulobox.selectedProperty().setValue(false);
		databox.selectedProperty().setValue(false);
		statusbox.selectedProperty().setValue(false);
	}
	
	public void Titulotrue (ActionEvent event)
	{
		databox.selectedProperty().setValue(false);
		statusbox.selectedProperty().setValue(false);
		if (!(usuario.getNivel() == 0))
		{
			autorbox.selectedProperty().setValue(false);
		}
	}
	
	public void Datatrue (ActionEvent event)
	{
		titulobox.selectedProperty().setValue(false);
		statusbox.selectedProperty().setValue(false);
		if (!(usuario.getNivel() == 0))
		{
			autorbox.selectedProperty().setValue(false);
		}
	}
	
	public void Statustrue (ActionEvent event)
	{
		titulobox.selectedProperty().setValue(false);
		databox.selectedProperty().setValue(false);
		if (!(usuario.getNivel() == 0))
		{
			autorbox.selectedProperty().setValue(false);
		}
	}
	
	public void Obratrue (ActionEvent event)
	{
		nomebox.selectedProperty().setValue(false);
	}
	
	public void Nometrue (ActionEvent event)
	{
		obrabox.selectedProperty().setValue(false);
	}
	
	public void AceitoAval (ActionEvent event)
	{
		negadobox.selectedProperty().setValue(false);
	}
	
	public void NegadoAval (ActionEvent event)
	{
		aceitobox.selectedProperty().setValue(false);
	}
	
	
	public void AbrirADMAvaliadores (ActionEvent event)
	{
		FrontControler.window = 1;
		Stage stage = (Stage) Pesquisa.getScene().getWindow();
		stage.close();
		TelaAdmAval tela2 = new TelaAdmAval();
		try
		{
			tela2.start(new Stage());
		} catch (Exception exep)
		 {
              exep.printStackTrace();
			} 
	}
	
	public void AbrirADMAutores (ActionEvent event)
	{
		FrontControler.window = 2;
		TelaAdmAutor tela2 = new TelaAdmAutor();
		Stage stage = (Stage) Pesquisa.getScene().getWindow();
		stage.close();
		try
		{
			tela2.start(new Stage());
		} catch (Exception exep)
		 {
              exep.printStackTrace();
			} 
	}

	
	public void AbrirADMObras (ActionEvent event)
	{
		FrontControler.window = 3;
		TelaAdmObra tela2 = new TelaAdmObra();
		Stage stage = (Stage) Pesquisa.getScene().getWindow();
		stage.close();
		try
		{
			tela2.start(new Stage());
		} catch (Exception exep)
		 {
              exep.printStackTrace();
			} 
	}
	
	public void EnviarNovoAutor (ActionEvent event) {
		AutorVO vo = new AutorVO();
		vo.setNome(NovoNome.getText());
		vo.setCPF(NovoCPF.getText());
		vo.setEndereco(NovoEndereço.getText());
		vo.setEmail(NovoEmail.getText());
		vo.setSenha(NovoSenha.getText());
		vo.setNivel(0);
		try {
			AutorBO bo = new AutorBO();
			bo.adicionarAutor(vo);
		}catch (Exception exep)		{ 
			  exep.printStackTrace();
	     }
		}
	
	public void EnviarNovoAvaliador (ActionEvent event) {
		AvaliadorVO vo = new AvaliadorVO();
		vo.setNome(NovoNome.getText());
		vo.setCPF(NovoCPF.getText());
		vo.setEndereco(NovoEndereço.getText());
		vo.setEmail(NovoEmail.getText());
		vo.setSenha(NovoSenha.getText());
		vo.setNivel(1);
		try {
			AvaliadorBO bo = new AvaliadorBO();
			bo.adicionarAvaliador(vo);
		}catch (Exception exep)		{
			  exep.printStackTrace();
	     }
	}
	
	
	public void EnviarNovoObra (ActionEvent event) {
		ObraVO vo = new ObraVO();
		vo.setTitulo(NomeObra.getText());
		vo.setGenero(GeneroObra.getText());
		vo.setEstado("Espera");
		Date data = new Date();
		SimpleDateFormat ano = new SimpleDateFormat("yyyy");
		String anoAval = ano.format(data);
		vo.setAno(anoAval);
		AutorBO autorid = new AutorBO();
		try {
			Long id = autorid.idAutor(usuario);
			AutorVO autor = new AutorVO();
			autor.setIdAutor(id);
			vo.setAutor(autor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			ObraBO bo = new ObraBO();
			bo.adicionarObra(vo);
		}catch (Exception exep)		{ 
			  exep.printStackTrace(); 
		}
		}
	
	
	public void AdicionarAvaliaçao (ActionEvent event) {
		AvaliaObraVO vo = new AvaliaObraVO();
		long idavaliador = Long.parseLong(IdAvaliadorAdicionar.getText());;
		long idobra = Long.parseLong(IdObraAdicionar.getText());
		ObraVO obra = new ObraVO();
		AvaliadorVO avaliador = new AvaliadorVO();
		
		vo.setObra(obra);
		vo.setAvaliador(avaliador);
		vo.setIdObra(idobra);
		vo.setIdAvaliador(idavaliador);
		
		AvaliaObraBO bo = new AvaliaObraBO();
		try {
			bo.adicionarAvaliacao(vo);
			ErroID.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
			ErroID.setVisible(true);
		}
	}
	
	public void RemoverAvaliaçao (ActionEvent event) {
		AvaliaObraVO vo = new AvaliaObraVO();
		long idavaliador = Long.parseLong(IdAvaliadorRemover.getText());;
		long idobra = Long.parseLong(IdObraRemover.getText());
		ObraVO obra = new ObraVO();
		AvaliadorVO avaliador = new AvaliadorVO();
		
		vo.setObra(obra);
		vo.setAvaliador(avaliador);
		vo.setIdObra(idobra);
		vo.setIdAvaliador(idavaliador);
		AvaliaObraBO bo = new AvaliaObraBO();
		try {
			vo.setIdAvalia(bo.IDAvaliação(vo));
			bo.excluirAvaliacao(vo);
			  ErroIDAvaliação.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
			  ErroIDAvaliação.setVisible(true);
		}
	}
	
	
	
	public void EditarAutor (ActionEvent event) {
		AutorVO vo = new AutorVO();
		vo.setNome(NomeEditarUsur.getText());
		vo.setCPF(CPFEditarUsur.getText());
		vo.setEndereco(EndereçoEditarUsur.getText());
		vo.setEmail(EmailEditarUsur.getText());
		vo.setSenha(SenhaEditarUsur.getText());
		long idautor = Long.parseLong(IDEditarUsur.getText());
		vo.setIdAutor(idautor);
		AutorBO usuarioautor = new AutorBO();
		try {
			vo.setIdUsuario(usuarioautor.idUsuarioAutor(vo));
		} catch (Exception e) {
			e.printStackTrace();
			}
		try {
			usuarioautor.editarAutor(vo);
			ErroID.setVisible(false);
		}catch (Exception exep)		{ 
			  exep.printStackTrace();
			  ErroID.setVisible(true);
			  }
		}

	public void EditarAvaliador (ActionEvent event) {
		AvaliadorVO vo = new AvaliadorVO();
		vo.setNome(NomeEditarUsur.getText());
		vo.setCPF(CPFEditarUsur.getText());
		vo.setEndereco(EndereçoEditarUsur.getText());
		vo.setEmail(EmailEditarUsur.getText());
		vo.setSenha(SenhaEditarUsur.getText());
		long idavaliador = Long.parseLong(IDEditarUsur.getText());
		vo.setIdAvaliador(idavaliador);
		AvaliadorBO usuarioavaliador = new AvaliadorBO();
		try {
			vo.setIdUsuario(usuarioavaliador.idUsuarioAvaliador(vo));
		} catch (Exception e) {
			e.printStackTrace();
			}
		try {
			usuarioavaliador.editarAvaliador(vo);
			ErroID.setVisible(false);
		}catch (Exception exep)		{ 
			  exep.printStackTrace();
			  ErroID.setVisible(true);
			  }
		}

	public void Avaliar (ActionEvent event)
	{
		long idobra = Long.parseLong(IDobraAvaliar.getText());
		ObraBO obra = new ObraBO();
		ObraVO obraatualizar = new ObraVO();
		try {
			obraatualizar = obra.ObraCatch(idobra);
			if(negadobox.selectedProperty().getValue())
			{
				obraatualizar.setEstado("Negado");
				ErroOpções.setVisible(false);
			} else if(aceitobox.selectedProperty().getValue())
			{
				obraatualizar.setEstado("Aceito");
				ErroOpções.setVisible(false);
			} else
			{
				ErroOpções.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		AvaliadorBO avaliador = new AvaliadorBO();
		AvaliaObraVO avaliaçãovo = new AvaliaObraVO();
		ObraVO obraid = new ObraVO();
		obraid.setIdObra(obraatualizar.getIdObra());
		avaliaçãovo.setObra(obraid);
		try {
			AvaliadorVO aval = new AvaliadorVO();
			aval.setIdAvaliador(avaliador.idAvaliador(usuario));
			avaliaçãovo.setAvaliador(aval);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		AvaliaObraBO avaliação = new AvaliaObraBO();
		
		try {
			if (avaliação.Verificar(avaliaçãovo)) 
			{
				obra.editarObra(obraatualizar);
				 ErroID.setVisible(false);
			} else {
				ErroID.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			ErroID.setVisible(true);
		}
	}
	
	public void ExcluirAutor (ActionEvent event)
	{
		long id = Long.parseLong(IDExcluir.getText());
		AutorVO excluirautor = new AutorVO();
		excluirautor.setIdAutor(id);
		AutorBO idexcluirautor = new AutorBO();
		try {
			excluirautor.setIdUsuario(idexcluirautor.idUsuarioAutor(excluirautor));
			 ErroIDExcluir.setVisible(false);
			 idexcluirautor.excluirAutor(excluirautor);
		} catch (Exception e) {
			e.printStackTrace();
			 ErroIDExcluir.setVisible(true);
		}
		
	}
	
	public void ExcluirAvaliador (ActionEvent event)
	{
		long id = Long.parseLong(IDExcluir.getText());
		AvaliadorVO excluiravaliador = new AvaliadorVO();
		excluiravaliador.setIdAvaliador(id);
		AvaliadorBO idexcluiravaliador = new AvaliadorBO();
		try {
			excluiravaliador.setIdUsuario(idexcluiravaliador.idUsuarioAvaliador(excluiravaliador));
			 ErroIDExcluir.setVisible(false);
			 idexcluiravaliador.excluirAvaliador(excluiravaliador);
		} catch (Exception e) {
			e.printStackTrace();
			 ErroIDExcluir.setVisible(true);
		}
		
	}
	public void ExcluirObra (ActionEvent event) {
		Long id = Long.parseLong(IDExcluir.getText());
		ObraVO vo = new ObraVO();
		vo.setIdObra(id);
		ObraBO bo = new ObraBO();
		try {
			bo.excluirObra(vo);
			ErroIDExcluir.setVisible(false);
		} catch (Exception e) {
				e.printStackTrace();
				ErroIDExcluir.setVisible(true);
		}
	
	}


	public void Pesquisar (ActionEvent event)  {
		if(Pesquisa.getText().isEmpty())
		{
		if(usuario.getNivel() == 2 && window == 3) {
		Titulocl.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		Generocl.setCellValueFactory(new PropertyValueFactory<>("genero"));
		Datacl.setCellValueFactory(new PropertyValueFactory<>("ano"));
		Statuscl.setCellValueFactory(new PropertyValueFactory<>("estado"));
		IddeObracl.setCellValueFactory(new PropertyValueFactory<>("idObra"));
		IdAutorcl.setCellValueFactory(new PropertyValueFactory<>("idAutor"));
		IdAvaliadorcl.setCellValueFactory(new PropertyValueFactory<>("idAvaliador"));
		IdObracl.setCellValueFactory(new PropertyValueFactory<>("idObra"));
		
		ObraBO obra = new ObraBO();
		ObservableList<ObraVO> obralist;
		try {
			obralist = FXCollections.observableArrayList(obra.listarObras()); 
			ObrasList.setItems(obralist);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		AvaliaObraBO avaliação = new AvaliaObraBO();
		ObservableList<AvaliaObraVO> avaliaçãolist;
		try {
			avaliaçãolist = FXCollections.observableArrayList(avaliação.listarAvaliacoes()); 

			AvaliaçõesList.setItems(avaliaçãolist);
		} catch (Exception e) {

			e.printStackTrace();
		}
		}
		
		if(usuario.getNivel() == 2 && window == 2) {
		Nomecl.setCellValueFactory(new PropertyValueFactory<>("nome"));
		CPFcl.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		Endereçocl.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		Emailcl.setCellValueFactory(new PropertyValueFactory<>("email"));
		Senhacl.setCellValueFactory(new PropertyValueFactory<>("senha"));
		IdAutorcl.setCellValueFactory(new PropertyValueFactory<>("idAutor"));
		
		AutorBO autor = new AutorBO();
		ObservableList<AutorVO> autorlist;
		try {
			autorlist = FXCollections.observableArrayList(autor.listarAutores()); 
			AutoresList.setItems(autorlist);
		} catch (Exception e) {

			e.printStackTrace();
		}
		}
		
		if(usuario.getNivel() == 2 && window == 1) {
		Nomecl.setCellValueFactory(new PropertyValueFactory<>("nome"));
		CPFcl.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		Endereçocl.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		Emailcl.setCellValueFactory(new PropertyValueFactory<>("email"));
		Senhacl.setCellValueFactory(new PropertyValueFactory<>("senha"));
		IdAvaliadorcl.setCellValueFactory(new PropertyValueFactory<>("idAvaliador"));
		AvaliadorBO avaliador = new AvaliadorBO();
		ObservableList<AvaliadorVO> avaliadorlist;
		try {
			avaliadorlist = FXCollections.observableArrayList(avaliador.listarAvaliadores()); 
			AvaliadoresList.setItems(avaliadorlist);
		} catch (Exception e) {

			e.printStackTrace();
			}
		}
	if(usuario.getNivel() == 0) {
		Titulocl.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		Generocl.setCellValueFactory(new PropertyValueFactory<>("genero"));
		Datacl.setCellValueFactory(new PropertyValueFactory<>("ano"));
		Statuscl.setCellValueFactory(new PropertyValueFactory<>("estado"));
		IdObracl.setCellValueFactory(new PropertyValueFactory<>("idObra"));
		
		AutorVO autor = new AutorVO();
		AutorBO autorbo = new AutorBO();
		
		ObraBO obra = new ObraBO();
		ObservableList<ObraVO> obralist;
		try {
			autor.setIdAutor(autorbo.idAutor(usuario));
			
			obralist = FXCollections.observableArrayList(obra.listarObrasAutor(autor)); 
			ObrasListBasic.setItems(obralist);
		} catch (Exception e) {

			e.printStackTrace();
			}
		}
	
	if(usuario.getNivel() == 1) {
		Titulocl.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		Generocl.setCellValueFactory(new PropertyValueFactory<>("genero"));
		Datacl.setCellValueFactory(new PropertyValueFactory<>("ano"));
		Statuscl.setCellValueFactory(new PropertyValueFactory<>("estado"));
		IdObracl.setCellValueFactory(new PropertyValueFactory<>("idObra"));
		
		AvaliadorVO avaliador = new AvaliadorVO();
		AvaliadorBO avaliadorbo = new AvaliadorBO();
		ObraBO obra = new ObraBO();
		ObservableList<ObraVO> obralist;
		try {
			avaliador.setIdAvaliador(avaliadorbo.idAvaliador(usuario));
			
			obralist = FXCollections.observableArrayList(obra.listarObrasAvaliador(avaliador)); 
			ObrasListBasic.setItems(obralist);
		} catch (Exception e) {

			e.printStackTrace();
			}
		} 
	} else if(usuario.getNivel() == 2 && window == 1)
		{			
		    if(obrabox.selectedProperty().getValue()) {
		    	errocaixa.setVisible(false);
		    	ObraVO avaliadorpes = new ObraVO();
		    	long id = Long.parseLong(Pesquisa.getText());
		    	avaliadorpes.setIdObra(id);
		    	Nomecl.setCellValueFactory(new PropertyValueFactory<>("nome"));
				CPFcl.setCellValueFactory(new PropertyValueFactory<>("CPF"));
				Endereçocl.setCellValueFactory(new PropertyValueFactory<>("endereco"));
				Emailcl.setCellValueFactory(new PropertyValueFactory<>("email"));
				Senhacl.setCellValueFactory(new PropertyValueFactory<>("senha"));
				IdAvaliadorcl.setCellValueFactory(new PropertyValueFactory<>("idAvaliador"));
				AvaliadorBO avaliador = new AvaliadorBO();
				ObservableList<AvaliadorVO> avaliadorlist;
				try {
					avaliadorlist = FXCollections.observableArrayList(avaliador.listarAvaliadoresObra(avaliadorpes)); 
					AvaliadoresList.setItems(avaliadorlist);
				} catch (Exception e) {

					e.printStackTrace();
					}
		   
			} else if(nomebox.selectedProperty().getValue()){
		    	errocaixa.setVisible(false);
		    	AvaliadorVO avaliadorpes = new AvaliadorVO();
		    	avaliadorpes.setNome(Pesquisa.getText());
		    	Nomecl.setCellValueFactory(new PropertyValueFactory<>("nome"));
				CPFcl.setCellValueFactory(new PropertyValueFactory<>("CPF"));
				Endereçocl.setCellValueFactory(new PropertyValueFactory<>("endereco"));
				Emailcl.setCellValueFactory(new PropertyValueFactory<>("email"));
				Senhacl.setCellValueFactory(new PropertyValueFactory<>("senha"));
				IdAvaliadorcl.setCellValueFactory(new PropertyValueFactory<>("idAvaliador"));
				AvaliadorBO avaliador = new AvaliadorBO();
				ObservableList<AvaliadorVO> avaliadorlist;
				try {
					avaliadorlist = FXCollections.observableArrayList(avaliador.listarAvaliadoresNome(avaliadorpes)); 
					AvaliadoresList.setItems(avaliadorlist);
				} catch (Exception e) {

					e.printStackTrace();
					}
				
			} else {
				errocaixa.setVisible(true);
			};
		} else if(usuario.getNivel() == 2 && window == 2) {
			if(obrabox.selectedProperty().getValue()) {
		    	errocaixa.setVisible(false);
				ObraVO autorpes = new ObraVO();
				long id = Long.parseLong(Pesquisa.getText());
				autorpes.setIdObra(id);
				Nomecl.setCellValueFactory(new PropertyValueFactory<>("nome"));
				CPFcl.setCellValueFactory(new PropertyValueFactory<>("CPF"));
				Endereçocl.setCellValueFactory(new PropertyValueFactory<>("endereco"));
				Emailcl.setCellValueFactory(new PropertyValueFactory<>("email"));
				Senhacl.setCellValueFactory(new PropertyValueFactory<>("senha"));
				IdAutorcl.setCellValueFactory(new PropertyValueFactory<>("idAutor"));
				
				AutorBO autor = new AutorBO();
				ObservableList<AutorVO> autorlist;
				try {
					autorlist = FXCollections.observableArrayList(autor.listarAutoresObra(autorpes)); 
					AutoresList.setItems(autorlist);
				} catch (Exception e) {

					e.printStackTrace();
				}		
			} else if(nomebox.selectedProperty().getValue()){
		    	errocaixa.setVisible(false);
				AutorVO autorpes = new AutorVO();
				autorpes.setNome(Pesquisa.getText());
				Nomecl.setCellValueFactory(new PropertyValueFactory<>("nome"));
				CPFcl.setCellValueFactory(new PropertyValueFactory<>("CPF"));
				Endereçocl.setCellValueFactory(new PropertyValueFactory<>("endereco"));
				Emailcl.setCellValueFactory(new PropertyValueFactory<>("email"));
				Senhacl.setCellValueFactory(new PropertyValueFactory<>("senha"));
				IdAutorcl.setCellValueFactory(new PropertyValueFactory<>("idAutor"));
				
				AutorBO autor = new AutorBO();
				ObservableList<AutorVO> autorlist;
				try {
					autorlist = FXCollections.observableArrayList(autor.listarAutoresNome(autorpes)); 
					AutoresList.setItems(autorlist);
				} catch (Exception e) {

					e.printStackTrace();
				}		
			} else {
				errocaixa.setVisible(true);
			};
		} else if(usuario.getNivel() == 2 && window == 3)
		{
			if (titulobox.selectedProperty().getValue())
			{   errocaixa.setVisible(false);
				ObraVO obrapes = new ObraVO();
				obrapes.setTitulo(Pesquisa.getText());
				Titulocl.setCellValueFactory(new PropertyValueFactory<>("titulo"));
				Generocl.setCellValueFactory(new PropertyValueFactory<>("genero"));
				Datacl.setCellValueFactory(new PropertyValueFactory<>("ano"));
				Statuscl.setCellValueFactory(new PropertyValueFactory<>("estado"));
				IddeObracl.setCellValueFactory(new PropertyValueFactory<>("idObra"));
				IdAutorcl.setCellValueFactory(new PropertyValueFactory<>("idAutor"));
				IdAvaliadorcl.setCellValueFactory(new PropertyValueFactory<>("idAvaliador"));
				IdObracl.setCellValueFactory(new PropertyValueFactory<>("idObra"));
				
				ObraBO obra = new ObraBO();
				ObservableList<ObraVO> obralist;
				try {
					obralist = FXCollections.observableArrayList(obra.listarObrasTitulo(obrapes)); 
					ObrasList.setItems(obralist);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			else if (databox.selectedProperty().getValue())
			{	errocaixa.setVisible(false);
				ObraVO obrapes = new ObraVO();
				obrapes.setAno(Pesquisa.getText());
				Titulocl.setCellValueFactory(new PropertyValueFactory<>("titulo"));
				Generocl.setCellValueFactory(new PropertyValueFactory<>("genero"));
				Datacl.setCellValueFactory(new PropertyValueFactory<>("ano"));
				Statuscl.setCellValueFactory(new PropertyValueFactory<>("estado"));
				IddeObracl.setCellValueFactory(new PropertyValueFactory<>("idObra"));
				IdAutorcl.setCellValueFactory(new PropertyValueFactory<>("idAutor"));
				IdAvaliadorcl.setCellValueFactory(new PropertyValueFactory<>("idAvaliador"));
				IdObracl.setCellValueFactory(new PropertyValueFactory<>("idObra"));
				
				ObraBO obra = new ObraBO();
				ObservableList<ObraVO> obralist;
				try {
					obralist = FXCollections.observableArrayList(obra.listarObrasData(obrapes)); 
					ObrasList.setItems(obralist);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			else if (statusbox.selectedProperty().getValue())
			{   errocaixa.setVisible(false);
				ObraVO obrapes = new ObraVO();
				obrapes.setTitulo("genericPesquisa");
				obrapes.setEstado(Pesquisa.getText());
				Titulocl.setCellValueFactory(new PropertyValueFactory<>("titulo"));
				Generocl.setCellValueFactory(new PropertyValueFactory<>("genero"));
				Datacl.setCellValueFactory(new PropertyValueFactory<>("ano"));
				Statuscl.setCellValueFactory(new PropertyValueFactory<>("estado"));
				IddeObracl.setCellValueFactory(new PropertyValueFactory<>("idObra"));
				IdAutorcl.setCellValueFactory(new PropertyValueFactory<>("idAutor"));
				IdAvaliadorcl.setCellValueFactory(new PropertyValueFactory<>("idAvaliador"));
				IdObracl.setCellValueFactory(new PropertyValueFactory<>("idObra"));
				
				ObraBO obra = new ObraBO();
				ObservableList<ObraVO> obralist;
				try {
					obralist = FXCollections.observableArrayList(obra.listarObrasStatus(obrapes)); 
					ObrasList.setItems(obralist);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			else if (autorbox.selectedProperty().getValue())
			{   errocaixa.setVisible(false);
				ObraVO obrapes = new ObraVO();
				Long id = Long.parseLong(Pesquisa.getText());
				AutorVO autor = new AutorVO();
				autor.setIdAutor(id);
				obrapes.setAutor(autor);
				Titulocl.setCellValueFactory(new PropertyValueFactory<>("titulo"));
				Generocl.setCellValueFactory(new PropertyValueFactory<>("genero"));
				Datacl.setCellValueFactory(new PropertyValueFactory<>("ano"));
				Statuscl.setCellValueFactory(new PropertyValueFactory<>("estado"));
				IddeObracl.setCellValueFactory(new PropertyValueFactory<>("idObra"));
				IdAutorcl.setCellValueFactory(new PropertyValueFactory<>("idAutor"));
				IdAvaliadorcl.setCellValueFactory(new PropertyValueFactory<>("idAvaliador"));
				IdObracl.setCellValueFactory(new PropertyValueFactory<>("idObra"));
				
				ObraBO obra = new ObraBO();
				ObservableList<ObraVO> obralist;
				try {
					obralist = FXCollections.observableArrayList(obra.listarObrasAutor(obrapes)); 
					ObrasList.setItems(obralist);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			else
			{
				errocaixa.setVisible(true);
			} }
		else  if (usuario.getNivel() == 1)
			{ 
			if (titulobox.selectedProperty().getValue())
			{   errocaixa.setVisible(false);
				ObraVO obrapes = new ObraVO();
				obrapes.setTitulo(Pesquisa.getText());
				Titulocl.setCellValueFactory(new PropertyValueFactory<>("titulo"));
				Generocl.setCellValueFactory(new PropertyValueFactory<>("genero"));
				Datacl.setCellValueFactory(new PropertyValueFactory<>("ano"));
				Statuscl.setCellValueFactory(new PropertyValueFactory<>("estado"));
				IdObracl.setCellValueFactory(new PropertyValueFactory<>("idObra"));
				
				AvaliadorVO avaliador = new AvaliadorVO();
				AvaliadorBO avaliadorbo = new AvaliadorBO();
				ObraBO obra = new ObraBO();
				ObservableList<ObraVO> obralist;
				try {
					avaliador.setIdAvaliador(avaliadorbo.idAvaliador(usuario));
					obralist = FXCollections.observableArrayList(obra.listarObrasTituloAval(obrapes, avaliador)); 
					ObrasListBasic.setItems(obralist);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			else if (databox.selectedProperty().getValue())
			{   errocaixa.setVisible(false);
				ObraVO obrapes = new ObraVO();
				obrapes.setAno(Pesquisa.getText());
				Titulocl.setCellValueFactory(new PropertyValueFactory<>("titulo"));
				Generocl.setCellValueFactory(new PropertyValueFactory<>("genero"));
				Datacl.setCellValueFactory(new PropertyValueFactory<>("ano"));
				Statuscl.setCellValueFactory(new PropertyValueFactory<>("estado"));
				IdObracl.setCellValueFactory(new PropertyValueFactory<>("idObra"));
				
				
				AvaliadorVO avaliador = new AvaliadorVO();
				AvaliadorBO avaliadorbo = new AvaliadorBO();
				ObraBO obra = new ObraBO();
				ObservableList<ObraVO> obralist;
				try {
					avaliador.setIdAvaliador(avaliadorbo.idAvaliador(usuario));
					obralist = FXCollections.observableArrayList(obra.listarObrasDataAval(obrapes, avaliador)); 
					ObrasListBasic.setItems(obralist);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			else if (statusbox.selectedProperty().getValue())
			{	errocaixa.setVisible(false);
				ObraVO obrapes = new ObraVO();
				obrapes.setTitulo("genericPesquisa");
				obrapes.setEstado(Pesquisa.getText());
				Titulocl.setCellValueFactory(new PropertyValueFactory<>("titulo"));
				Generocl.setCellValueFactory(new PropertyValueFactory<>("genero"));
				Datacl.setCellValueFactory(new PropertyValueFactory<>("ano"));
				Statuscl.setCellValueFactory(new PropertyValueFactory<>("estado"));
				IdObracl.setCellValueFactory(new PropertyValueFactory<>("idObra"));
				
				
				AvaliadorVO avaliador = new AvaliadorVO();
				AvaliadorBO avaliadorbo = new AvaliadorBO();
				ObraBO obra = new ObraBO();
				ObservableList<ObraVO> obralist;
				try {
					avaliador.setIdAvaliador(avaliadorbo.idAvaliador(usuario));
					obralist = FXCollections.observableArrayList(obra.listarObrasStatusAval(obrapes, avaliador)); 
					ObrasListBasic.setItems(obralist);
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
			else if (autorbox.selectedProperty().getValue())
			{	errocaixa.setVisible(false);
				ObraVO obrapes = new ObraVO();
				Long id = Long.parseLong(Pesquisa.getText());
				AutorVO autor = new AutorVO();
				autor.setIdAutor(id);
				obrapes.setAutor(autor);
				Titulocl.setCellValueFactory(new PropertyValueFactory<>("titulo"));
				Generocl.setCellValueFactory(new PropertyValueFactory<>("genero"));
				Datacl.setCellValueFactory(new PropertyValueFactory<>("ano"));
				Statuscl.setCellValueFactory(new PropertyValueFactory<>("estado"));
				IdObracl.setCellValueFactory(new PropertyValueFactory<>("idObra"));
				
				
				AvaliadorVO avaliador = new AvaliadorVO();
				AvaliadorBO avaliadorbo = new AvaliadorBO();
				ObraBO obra = new ObraBO();
				ObservableList<ObraVO> obralist;
				try {
					avaliador.setIdAvaliador(avaliadorbo.idAvaliador(usuario));
					obralist = FXCollections.observableArrayList(obra.listarObrasAutorAval(obrapes, avaliador)); 
					ObrasListBasic.setItems(obralist);
				} catch (Exception e) {

					e.printStackTrace();
				}

			} else {
				errocaixa.setVisible(true);
			}
		} else  if (usuario.getNivel() == 0)
		{ 
		if (titulobox.selectedProperty().getValue())
		{   errocaixa.setVisible(false);
			ObraVO obrapes = new ObraVO();
			obrapes.setTitulo(Pesquisa.getText());
			Titulocl.setCellValueFactory(new PropertyValueFactory<>("titulo"));
			Generocl.setCellValueFactory(new PropertyValueFactory<>("genero"));
			Datacl.setCellValueFactory(new PropertyValueFactory<>("ano"));
			Statuscl.setCellValueFactory(new PropertyValueFactory<>("estado"));
			IdObracl.setCellValueFactory(new PropertyValueFactory<>("idObra"));
			
			AutorVO autor = new AutorVO();
			AutorBO autorbo = new AutorBO();
			ObraBO obra = new ObraBO();
			ObservableList<ObraVO> obralist;
			try {
				autor.setIdAutor(autorbo.idAutor(usuario));
				obralist = FXCollections.observableArrayList(obra.listarObrasTituloAutor(obrapes, autor)); 
				ObrasListBasic.setItems(obralist);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		else if (databox.selectedProperty().getValue())
		{   errocaixa.setVisible(false);
			ObraVO obrapes = new ObraVO();
			obrapes.setAno(Pesquisa.getText());
			Titulocl.setCellValueFactory(new PropertyValueFactory<>("titulo"));
			Generocl.setCellValueFactory(new PropertyValueFactory<>("genero"));
			Datacl.setCellValueFactory(new PropertyValueFactory<>("ano"));
			Statuscl.setCellValueFactory(new PropertyValueFactory<>("estado"));
			IdObracl.setCellValueFactory(new PropertyValueFactory<>("idObra"));
			
			
			AutorVO autor = new AutorVO();
			AutorBO autorbo = new AutorBO();
			ObraBO obra = new ObraBO();
			ObservableList<ObraVO> obralist;
			try {
				autor.setIdAutor(autorbo.idAutor(usuario));
				obralist = FXCollections.observableArrayList(obra.listarObrasDataAutor(obrapes, autor)); 
				ObrasListBasic.setItems(obralist);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		else if (statusbox.selectedProperty().getValue())
		{	errocaixa.setVisible(false);
			ObraVO obrapes = new ObraVO();
			obrapes.setTitulo("genericPesquisa");
			obrapes.setEstado(Pesquisa.getText());
			Titulocl.setCellValueFactory(new PropertyValueFactory<>("titulo"));
			Generocl.setCellValueFactory(new PropertyValueFactory<>("genero"));
			Datacl.setCellValueFactory(new PropertyValueFactory<>("ano"));
			Statuscl.setCellValueFactory(new PropertyValueFactory<>("estado"));
			IdObracl.setCellValueFactory(new PropertyValueFactory<>("idObra"));
			
			
			AutorVO autor = new AutorVO();
			AutorBO autorbo = new AutorBO();
			ObraBO obra = new ObraBO();
			ObservableList<ObraVO> obralist;
			try {
				autor.setIdAutor(autorbo.idAutor(usuario));
				obralist = FXCollections.observableArrayList(obra.listarObrasStatusAutor(obrapes, autor)); 
				ObrasListBasic.setItems(obralist);
			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {
			errocaixa.setVisible(true);
		}

	
	}	
}
};