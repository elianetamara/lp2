public class CronicasDoEstudanteSistema {

    private Cronica[] cronicas;

    private Livreto[] livretos;

    public CronicasDoEstudanteSistema() {
        cronicas = new Cronica[1000];
        for (int i = 0; i < cronicas.length; i++) {
            cronicas[i] = new Cronica("", "", "", "");
        }
        livretos = new Livreto[100];
        for (int i = 0; i < livretos.length; i++) {
            livretos[1] = new Livreto();
        }
    }

    public void criarLivreto(int[] posicoes){
        Livreto l1 = new Livreto();
        l1.aumentaId();
        if(posicoes.length <3 || posicoes.length > 5){
            throw new IllegalArgumentException("NÚMERO DE CRÔNICAS NÃO PERMITIDO PELO SISTEMA");
        }
        for (int i = 1; i < posicoes.length; i++) {
            l1.getCronicasLivreto()[i-1] = getCronica(posicoes[i-1]);
        }
        if(l1.getId() > 100){
            l1.setId(0);
            livretos[l1.getId()] = l1;
        }
        livretos[l1.getId()] = l1;
    }

    public String lerlivreto(int i){
        return livretos[i-1].toString();
    }

    public boolean contemCronicaNoLivreto(String titulo, int i){
        for (Cronica c: livretos[i-1].getCronicasLivreto()) {
            if(titulo.equals(c.getTitulo())){
                return true;
            }
        }
        return false;
    }

    public void cadastrarCronica(String titulo, String texto, String data, String autor) {
        Cronica c1 = new Cronica(autor, titulo, texto, data);
        c1.setId();
        if (titulo.isBlank() || texto.isBlank() || data.isBlank()) {
            throw new IllegalArgumentException("CAMPOS OBRIGATÓRIOS");
        }
        for (Cronica c : cronicas) {
            if (c.equals(c1)) {
                throw new IllegalArgumentException("Crônica já existe no sistema");
            }
        }
        cronicas[c1.getId()] = c1;

    }

    public void cadastrarCronica(String titulo, String texto, String data){
        Cronica c2 = new Cronica(titulo, texto, data);
        c2.setId();
        if (titulo.isBlank() || texto.isBlank() || data.isBlank()) {
            throw new IllegalArgumentException("CAMPOS OBRIGATÓRIOS");
        }
        for (Cronica c : cronicas) {
            if (c.equals(c2)) {
                throw new IllegalArgumentException("Crônica já existe no sistema");
            }
        }
            cronicas[c2.getId()] = c2;
    }

    private Cronica getCronica(int i){
        return cronicas[i-1];
    }

    private Livreto getLivreto(int i){
        return livretos[i-1];
    }

    public String listarCronicas(){
        String saida = "Crônicas:\n";
        for (Cronica c: cronicas) {
            saida += c.toString() + "\n";
        }
        return saida;
    }

    public String lerCronica(int i){
        getCronica(i).setQtdLeituras();
        return getCronica(i).toString();
    }

    public String exibirCronicaMaisLida(){
        Cronica maisLida = new Cronica("", "", "", "");
        for (int i = 1; i < cronicas.length; i++) {
            if(cronicas[i-1].getQtdLeituras() > maisLida.getQtdLeituras()){
                maisLida = cronicas[i];
            }
        }
        return maisLida.toString();
    }
}


