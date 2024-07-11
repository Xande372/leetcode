// count-pairs-whose-sum-is-less-than-target

public class BuscaBinaria {

    public int countPairs(List<Integer> nums, int target) {
        
        // classifica a ordem do array em crescente.
        Collections.sort(nums);

        // variáveis para guardar a contagem, pegar o primeiro índice e o último índice.
        int count = 0;
        int left = 0;
        int right = nums.size() - 1;

        // looping até a variável esquerda ser menor que a direita.
        while(left < right) {

            // Se a soma dos ponteiros for menor que o target, significa que todos os pares com o elemento esquerdo atual também satisfarão a condição.
            // Senão, se for maior ou igual ao target, mova o ponteiro direito para a esquerda.
            if(nums.get(left) + nums.get(right) < target){

                // atualiza a contagem e incrementa o ponteiro esquerdo.
                // e pq usar essa expressão em count? pq o número de pares que você pode fazer será direita-esquerda, então é um atalho para obter a contagem até lá.
                count += right - left;
                left++;

            } else {

                // diminui o ponteiro direito.
                right--;
            }
        }
        return count;
    }
}
