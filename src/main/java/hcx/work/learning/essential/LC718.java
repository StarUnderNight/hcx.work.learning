package hcx.work.learning.essential;

public class LC718 {

    public int findLength(int[] A, int[] B) {
	int aLen = A.length;
	int bLen = B.length;
	int ret = 0;
	for (int i = 0; i < aLen; i++) {
	    int len = Math.min(aLen - i, bLen);
	    int maxLen = maxLength(A, B, i, 0, len);
	    ret = Math.max(ret, maxLen);
	}
	for (int i = 0; i < bLen; i++) {
	    int len = Math.min(bLen - i, aLen);
	    int maxLen = maxLength(A, B, 0, i, len);
	    ret = Math.max(ret, maxLen);
	}
	return ret;

    }

    public int maxLength(int[] A, int[] B, int idxA, int idxB, int len) {
	int ret = 0;
	int k = 0;
	for (int i = 0; i < len; i++) {
	    if (A[idxA + i] == B[idxB + i]) {
		k++;
	    } else {
		k = 0;
	    }

	    ret = Math.max(ret, k);
	}
	return ret;
    }
}
