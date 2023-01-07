public class TesteConexaoFinally {
	public static void main(String[] args) {
		Conexao conexao = null;
		// Um try exige pelo menos um catch ou um finally
		try {
			conexao = new Conexao();
			conexao.incicarConexao();
			conexao.getDados();
		} catch(IllegalStateException exception) {
			System.out.println("Ocorreu um erro no recebimento dos dados.");
			// A ideia do finally é	 que ele sempre seja executado. Mesmo que try ou catch sera executado.
		} finally {
			conexao.fecharConexao();
		}
	}
}
