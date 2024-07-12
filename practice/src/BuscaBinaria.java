import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BuscaBinaria {

    // Exercício 1: Count Pairs Whose Sum is Less than target;
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

    // Exercício 2: Find Target Indices After Sorting Array;
    public List<Integer> targetIndices(int[] nums, int target) {
        
        // a matriz é ordenada para achar o target.
        Arrays.sort(nums);
 
         // cria uma nova lista para adicionar o target dentro.
        ArrayList<Integer> listaTarget = new ArrayList<Integer>();
 
         // um looping para percorrer toda a matriz ordenada.
        for(int i = 0; i < nums.length; i++) {
             // se o índice i for igual ao target ele irá adicionar em outra lista para depois ser impressa.
             if(nums[i] == target) {
                 listaTarget.add(i);
             }
        }
        return listaTarget;
    }

    //Exercício 3: Busca Binaria.
    public int search(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    //Exercício 4: Two Sum II - Input Array is Sorted
    public int[] twoSum(int[] numbers, int target) {
        
        int left = 0;
        int right = numbers.length - 1;

        while(left < right) {

            int soma = numbers[left] + numbers[right];

            if(soma == target) {
                return new int[]{left + 1, right + 1};
            }
            
            if(soma > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }

    //Exercício 5: Search Insert Position
    public int searchInsert(int[] nums, int target) {
        
        // começa indicando onde ficaram os ponteiros.
        int left = 0;
        int right = nums.length - 1;

        // cria um looping para validar a lista de busca, com a regra.
        while(left <= right) {

            // calcula o index do meio de uma distância definida pelo left and right.
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) { // se o elemento no midpoint for igual, retornamos o index do mid.
                return mid;
            } else if(nums[mid] > target) { // se o midpoint for maior, significa que o target deve estar na metade pra esquerda e ai ajustamos o ponteiro direito para o mid - 1.
                right = mid - 1;
            } else { // se o midpoint for menor, então teremos que procurar na metade da direita, passando o ponteiro da esquerda para o mid + 1.
                left = mid + 1;
            }
        }

        // se o target não for achado o loop irá se encerrar quando o left for maior que o right. Neste ponto, left deverá ser o index onde o target tem que ser inserido para manter um Sorted order.
        return left;
    }
}
