package Entity;

public class Page {

    private int currentPage=1;    //当前页数
    private int totalPages;       //总页数
    private int totalItems;            //记录总行数
    private int pageSize=5;    //每页记录行数
    private int nextPage;        //下一页
    private int prefPage;       //前一页

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    //获取总页数。除不尽的向上进一位
    public int getTotalPages() {
        totalPages = totalItems % pageSize == 0 ? totalItems / pageSize :totalItems / pageSize + 1;
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalItems() {
        return totalItems;
    }


    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    //获取下一页。不会超过能返回的最大页数。
    public int getNextPage() {
        if (currentPage < totalPages) {
            nextPage = currentPage + 1;
        } else {
            nextPage = currentPage;
        }
        return nextPage;
    }

    public void setPrefPage(int prefPage) {
        this.prefPage = prefPage;
    }

    //获取上一页。不会小于第一页。
    public int getPrefPage() {
        if (currentPage > 1) {
            prefPage = currentPage - 1;
        } else {
            prefPage = currentPage;
        }
        return prefPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }





}
