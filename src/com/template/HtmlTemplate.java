package com.template;

public abstract class HtmlTemplate {
    public void showHeader() {
        System.out.println("<html>");
        System.out.println("<head>");
        System.out.println("<title>C0221H1-Template Pattern</title>");
        System.out.println("</head>");
    }

    public abstract void showBody();

    public void showFooter() {
        System.out.println("</html>");
    }

    public void displayPage() {
        showHeader();
        showBody();
        showFooter();
    }
}
