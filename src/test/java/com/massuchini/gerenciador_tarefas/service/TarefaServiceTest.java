package com.massuchini.gerenciador_tarefas.service;

import com.massuchini.gerenciador_tarefas.entity.Tarefa;
import com.massuchini.gerenciador_tarefas.repository.TarefaRespository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // Habilita a integração do Mockito com o JUnit 5
class TarefaServiceTest {

    @Mock // Cria um "dublê" (mock) do nosso TarefaRepository
    private TarefaRespository tarefaRespository;

    @InjectMocks // Cria uma instância real do TarefaService e injeta os mocks (@Mock) nele
    private TarefaService tarefaService;

    @Test // Marca este método como um caso de teste
    @DisplayName("Deve retornar uma tarefa com sucesso quando o ID existir")
    void deveBuscarTarefaPorIdComSucesso() {
        // --- ARRANGE (Arranjo) ---
        // 1. Criamos um objeto Tarefa falso para ser o nosso resultado esperado.
        Tarefa tarefaFicticia = new Tarefa();
        tarefaFicticia.setId(1L);
        tarefaFicticia.setTitulo("Tarefa Teste");

        // 2. Ensinamos o nosso "dublê" (mock) a se comportar.
        // "QUANDO o método findById com o argumento 1L for chamado no repositório,
        // ENTÃO retorne um Optional contendo nossa tarefaFicticia."
        when(tarefaRespository.findById(1L)).thenReturn(Optional.of(tarefaFicticia));

        // --- ACT (Ação) ---
        // 3. Executamos o método que queremos testar.
        Tarefa tarefaResultado = tarefaService.buscarPorId(1L);

        // --- ASSERT (Verificação) ---
        // 4. Verificamos se o resultado é o esperado.
        assertThat(tarefaResultado).isNotNull();
        assertThat(tarefaResultado.getId()).isEqualTo(1L);
        assertThat(tarefaResultado.getTitulo()).isEqualTo("Tarefa Teste");
    }

    @Test
    @DisplayName("Deve lançar uma exceção quando o ID da tarefa não existir")
    void deveLancarExcecaoQuandoBuscarIdInexistente() {
        // --- ARRANGE ---
        // 1. Ensinamos o mock a retornar um Optional vazio para um ID que não existe.
        when(tarefaRespository.findById(99L)).thenReturn(Optional.empty());

        // --- ACT & ASSERT ---
        // 2. Verificamos se, ao executar o método buscarPorId(99L),
        // uma exceção do tipo RuntimeException é lançada.
        assertThrows(RuntimeException.class, () -> {
            tarefaService.buscarPorId(99L);
        });
    }
}