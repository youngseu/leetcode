package ArrayorList;

//274 problem
//H-Index
//Given an array of citations (each citation is a non-negative integer) of a researcher, write a
//function to compute the researcher's h-index.
public class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];
        for (int citation : citations) {
            if (citation >= n) buckets[n]++;
            else buckets[citation]++;
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += buckets[i];
            if (count >= i) return i;
        }
        return 0;
    }
}
