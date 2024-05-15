class OutlierFinder {
    public static int findOutlier(int[] sequence) {
        int sum = 0;
        int squaredSum = 0;

        // Вычисляем сумму и сумму квадратов элементов последовательности
        for (int num : sequence) {
            sum += num;
            squaredSum += num * num;
        }
        int mean = sum / sequence.length;
        int variance = (squaredSum / sequence.length) - (mean * mean);

        int maxDiff = Integer.MIN_VALUE;
        int outlier = -1;

        // Находим элемент, максимально отличающийся от среднего
        for (int num : sequence) {
            int diff = Math.abs(num - mean);
            if (diff > maxDiff) {
                maxDiff = diff;
                outlier = num;
            }
        }

        return outlier;
    }

    public static void main(String[] args) {
        int[] sequence = { 1, 2, 3, 4, 5, 6, 100 };
        int outlier = findOutlier(sequence);
        System.out.println("Выброс в последовательности: " + outlier);
    }
}
