import java.util.ArrayList;
import java.util.List;

import br.ifgoiano.model.Autor;
import br.ifgoiano.model.Editora;
import br.ifgoiano.model.Livro;
import br.ifgoiano.service.impl.AutorServiceImpl;
import br.ifgoiano.service.impl.EditoraServiceImpl;
import br.ifgoiano.service.impl.LivroServiceImpl;

public class Atividade1 {

    public static void main(String[] args) {

        LivroServiceImpl livroService = new LivroServiceImpl();
        EditoraServiceImpl editoraService = new EditoraServiceImpl();
        AutorServiceImpl autorService = new AutorServiceImpl();

        // Cadastro
        Livro livro1 = new Livro();
        livro1.setTitulo("Harry Potter e a Pedra Filosofal");
        livro1.setAnoPub(2006);
        livro1.setIsbn("34343");

        Livro livro2 = new Livro();
        livro2.setTitulo("Harry Potter e a Camera Secreta");
        livro2.setAnoPub(2007);
        livro2.setIsbn("34343");

        List<Livro> listaLivro = new ArrayList<>();
        listaLivro.add(livro1);
        listaLivro.add(livro2);

        Editora editora = new Editora();
        editora.setNome("Saraiva");
        editora.setLivros(listaLivro);

        if (editoraService.save(editora)) {
            System.out.println("\nEditora " + editora.getNome() + " salva com sucesso!");
        }

        Autor autor = new Autor();
        autor.setNome("JK.Rowling");
        autor.setLivros(listaLivro);

        if (autorService.save(autor)) {
            System.out.println("\nAutor " + autor.getNome() + " salvo com sucesso!");
        }

        livro1.setEditora(editora);
        livro2.setEditora(editora);

        livro1.setAutor(autor);
        livro2.setAutor(autor);

        livroService.update(livro1);
        livroService.update(livro2);
        
 // BUSCAS
//        System.out.println("\n===================================");
//        System.out.println("\nLivros: "+livroService.findAll().toString());
//        System.out.println("===================================");
//        System.out.println("\nAutores e seus livros: "+autorService.findAll().toString());
//        System.out.println("===================================");
//        System.out.println("\nEditoras e seus livros: "+editoraService.findAll().toString());
        
    }
}
