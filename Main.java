import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Post> posts = new ArrayList<>();
        int lastPostId = 0;

        while (true) {
            System.out.print("명령어) ");
            String command = sc.nextLine();

            switch (command) {
                case "등록":
                    registerPost(sc, posts, ++lastPostId);
                    break;

                case "목록":
                    displayPosts(posts);
                    break;

                case "종료":
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;

                default:
                    System.out.println("알 수 없는 명령어입니다.");
                    break;
            }
        }
    }

    private static void registerPost(Scanner sc, ArrayList<Post> posts, int postId) {
        System.out.print("제목 : ");
        String title = sc.nextLine();

        System.out.print("내용 : ");
        String content = sc.nextLine();

        posts.add(new Post(postId, title, content));
        System.out.println("[알림] " + postId + "번글이 등록되었습니다.");
    }

    private static void displayPosts(ArrayList<Post> posts) {
        if (posts.isEmpty()) {
            System.out.println("내용이 없습니다.");
            return;
        }

        System.out.println("번호 / 제목");
        System.out.println("-------------------");
        for (int i = posts.size() - 1; i >= 0; i--) {
            Post post = posts.get(i);
            System.out.println(post.id + " / " + post.title);
        }
    }
}

class Post {
    int id;
    String title;
    String content;

    public Post(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
