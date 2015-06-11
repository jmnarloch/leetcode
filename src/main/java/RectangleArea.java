/**
 *
 */
public class RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        final int I = Math.max(A, E);
        final int J = Math.max(B, F);
        final int K = Math.min(C, G);
        final int L = Math.min(D, H);

        final int total = (C - A) * (D - B) + (G - E) * (H - F);

        if(I > K || J > L) {
            return total;
        } else {
            final int union = (K - I) * (L - J);
            return total - union;
        }
    }
}
