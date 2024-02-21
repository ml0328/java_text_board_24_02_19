package com.ML.exam.board;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println( "== 자바 텍스트 게시판 0.1v ==");
    System.out.println("== 자바 텍스트 게시판 시작 ==");

    Scanner sc = new Scanner (System.in);
    int articleLastId = 0;
    Article lastArticle = null;

    while (true) {
      System.out.printf("명령 )");
      String cmd = sc.nextLine();

      if (cmd.equals("/usr/article/write")) {
        System.out.printf("제목 : ");
        String title = sc.nextLine();

        System.out.printf("내용 : ") ;
        String body = sc.nextLine();

        int id = articleLastId + 1;

        Article article = new Article(id, title, body);
        lastArticle = article;


        System.out.println("생성 된 게시물 객체 : " + article);
        System.out.printf("%d번 게시물이 생성되었습니다.\n", article.id);
        articleLastId++;

      }
      else if (cmd.equals("/usr/article/detail")) {
        if(lastArticle == null) {
          System.out.println("게시물이 존재하지 않습니다.");
          continue;
        }
        Article article = lastArticle;
        System.out.println("== 게시물 상세내용 ==");
        System.out.printf("번호 : %d\n", article.id) ;
        System.out.printf("제목 : %s\n", article.title);
        System.out.printf("내용 : %s\n", article.body);
      }

      else if (cmd.equals("exit")) {
        System.out.println("프로그램을 종료합니다.");
        break;
      }

      System.out.printf("입력받은 명령어 : %s\n", cmd);
    }
    System.out.println("== 자바 텍스트 게시판 종료==");
    sc.close();

  }
}
class Article {
  int id;
  String title;
  String body;
  Article (int id, String title, String body) {
    this.id = id;
    this.title = title;
    this.body = body;
  }
  public String toString () {
    return String.format ("{id : %d, title : \"%s\", body : \"%s\"}", id, title, body);
  }
}