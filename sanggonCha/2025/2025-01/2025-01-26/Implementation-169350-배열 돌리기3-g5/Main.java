import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, R, temp;
    private static int[] line;
    private static int[][] arr, tempArr, newArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M, R 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 배열 입력 받기
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // R개의 연산
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            commands(Integer.parseInt(st.nextToken()));
        }

        printArr();

    }

    private static void commands(int command) {
        switch (command) {
            case 1: // 상하 반전
                line = new int[M];
                for (int i = 0; i < N / 2; i++) {
                    System.arraycopy(arr[i], 0, line, 0, M); // i -> line
                    System.arraycopy(arr[N - 1 - i], 0, arr[i], 0, M); // N-i -> i
                    System.arraycopy(line, 0, arr[N - 1 - i], 0, M); // line -> N-1
                }
                break;

            case 2: // 좌우 반전
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M / 2; j++) {
                        temp = arr[i][j];
                        arr[i][j] = arr[i][M - 1 - j];
                        arr[i][M - 1 - j] = temp;
                    }
                }
                break;

            case 3: // 오른쪽으로 90도 회전
                newArr = new int[M][N];

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        newArr[j][N - 1 - i] = arr[i][j];
                    }
                }

                temp = N;
                N = M;
                M = temp;

                arr = newArr;
                break;

            case 4: // 왼쪽으로 90도 회전
                newArr = new int[M][N];

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        newArr[M - 1 - j][i] = arr[i][j];
                    }
                }

                temp = N;
                N = M;
                M = temp;

                arr = newArr;
                break;

            // N, M은 짝수
            case 5: // 시계방향
                tempArr = new int[N / 2][M / 2];

                // copy & ↑
                for (int i = 0; i < N / 2; i++) {
                    for (int j = 0; j < M / 2; j++) {
                        tempArr[i][j] = arr[i][j];
                        arr[i][j] = arr[i + N / 2][j];
                    }
                }

                // ←
                for (int i = N / 2; i < N; i++) {
                    for (int j = 0; j < M / 2; j++) {
                        arr[i][j] = arr[i][j + M / 2];
                    }
                }

                // ↓
                for (int i = 0; i < N / 2; i++) {
                    for (int j = M / 2; j < M; j++) {
                        arr[i + N / 2][j] = arr[i][j];
                    }
                }

                // →
                for (int i = 0; i < N / 2; i++) {
                    for (int j = 0; j < M / 2; j++) {
                        arr[i][j + M / 2] = tempArr[i][j];
                    }
                }

                break;

            case 6: // 반시계방향
                tempArr = new int[N / 2][M / 2];

                // copy & ←
                for (int i = 0; i < N / 2; i++) {
                    for (int j = 0; j < M / 2; j++) {
                        tempArr[i][j] = arr[i][j];
                        arr[i][j] = arr[i][j + M / 2];
                    }
                }

                // ↑
                for (int i = 0; i < N / 2; i++) {
                    for (int j = M / 2; j < M; j++) {
                        arr[i][j] = arr[i + N / 2][j];
                    }
                }

                // →
                for (int i = N / 2; i < N; i++) {
                    for (int j = M / 2; j < M; j++) {
                        arr[i][j] = arr[i][j - M / 2];
                    }
                }

                // ↓
                for (int i = N / 2; i < N; i++) {
                    for (int j = 0; j < M / 2; j++) {
                        arr[i][j] = tempArr[i - N / 2][j];
                    }
                }
                break;
            default:
                break;
        }
    }

    private static void printArr() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}