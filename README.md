{
  "nbformat": 4,
  "nbformat_minor": 0,
  "metadata": {
    "colab": {
      "name": "README.md",
      "provenance": []
    },
    "kernelspec": {
      "name": "python3",
      "display_name": "Python 3"
    }
  },
  "cells": [
    {
      "cell_type": "markdown",
      "metadata": {
        "id": "WIdlQcWCjh_W",
        "colab_type": "text"
      },
      "source": [
        "# 2020/01/15\n",
        "\n",
        "\n",
        "\n",
        "### 1) \n",
        "백준에서 Java 문제를 풀 경우, class는 Main으로 바꾸어 제출하기\n",
        "\n",
        "파일 명명법 : boj_문제번호.java  \n",
        "\n",
        "\n",
        "\n",
        "---\n",
        "  \n",
        "\n",
        "\n",
        "\n",
        "\n",
        "### 2)\n",
        "\n",
        "\n",
        "```java\n",
        "// java 입력 받기\n",
        "\n",
        "    import java.util.Scanner;\n",
        "\n",
        "    public class boj_1000 {\n",
        "        \tpublic static void main(String[] args) {\n",
        "\t\t    Scanner scanner = new Scanner(System.in);\n",
        "\t\t    int a = scanner.nextInt();\n",
        "\t\t    int b = scanner.nextInt();\n",
        "\t\t    scanner.close();\n",
        "\t\t\n",
        "\t\t    System.out.println(a+b);\n",
        "            }\n",
        "    }\n",
        "\n",
        "```\n",
        "\n",
        "scanner.nextInt() = int값 리턴\n",
        "\n",
        "scanner.close() = 꼭 스캐너 사용 종료 해주기\n",
        "\n",
        "__https://mine-it-record.tistory.com/103__ (참고★)\n",
        "\n"
      ]
    }
  ]
}
