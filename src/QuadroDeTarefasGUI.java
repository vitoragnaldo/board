import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class QuadroDeTarefasGUI extends JFrame {

    private List<String> tarefas = new ArrayList<>();
    private JTextArea listaTarefas;
    private JTextField novaTarefa;

    public QuadroDeTarefasGUI() {
        setTitle("Quadro de Tarefas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        listaTarefas = new JTextArea();
        listaTarefas.setEditable(false);
        add(new JScrollPane(listaTarefas), BorderLayout.CENTER);

        JPanel painelInferior = new JPanel();
        novaTarefa = new JTextField(20);
        JButton botaoAdicionar = new JButton("Adicionar");
        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarTarefa();
            }
        });

        painelInferior.add(novaTarefa);
        painelInferior.add(botaoAdicionar);
        add(painelInferior, BorderLayout.SOUTH);

        atualizarListaTarefas();
    }

    private void adicionarTarefa() {
        String tarefa = novaTarefa.getText();
        if (!tarefa.isEmpty()) {
            tarefas.add(tarefa);
            novaTarefa.setText("");
            atualizarListaTarefas();
        }
    }

    private void atualizarListaTarefas() {
        listaTarefas.setText("");
        for (int i = 0; i < tarefas.size(); i++) {
            listaTarefas.append((i + 1) + ". " + tarefas.get(i) + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuadroDeTarefasGUI().setVisible(true);
            }
        });
    }
}