package com.github.streamshub.systemtests.locators;

public class TopicsPageSelectors {
    private TopicsPageSelectors() {}
    // ----------------------------
    // Topics page
    // ----------------------------
    public static final String TPS_HEADER_TOTAL_TOPICS_BADGE = new CssBuilder(CssSelectors.PAGES_CONTENT_HEADER_TITLE_CONTENT_ITEMS)
        .nth(2).withChild()
        .withElementSpan().withComponentLabel().withChild()
        .withElementSpan().withComponentLabel().withSubComponentContent().withChild()
        .withElementSpan().withComponentLabel().withSubComponentText()
        .build();

    public static final String TPS_HEADER_BADGE_STATUS_SUCCESS = new CssBuilder(CssSelectors.PAGES_CONTENT_HEADER_TITLE_CONTENT_ITEMS)
        .nth(3).withChild()
        .withElementDiv().withChild()
        .withElementSpan().withComponentLabel().withChild()
        .withElementSpan().withComponentLabel().withSubComponentContent().withChild()
        .withElementSpan().withComponentLabel().withSubComponentText()
        .build();

    public static final String TPS_HEADER_BADGE_STATUS_WARNING = new CssBuilder(CssSelectors.PAGES_CONTENT_HEADER_TITLE_CONTENT_ITEMS)
        .nth(4).withChild()
        .withElementDiv().withChild()
        .withElementSpan().withComponentLabel().withChild()
        .withElementSpan().withComponentLabel().withSubComponentContent().withChild()
        .withElementSpan().withComponentLabel().withSubComponentText()
        .build();

    public static final String TPS_HEADER_BADGE_STATUS_ERROR = new CssBuilder(CssSelectors.PAGES_CONTENT_HEADER_TITLE_CONTENT_ITEMS)
        .nth(5).withChild()
        .withElementDiv().withChild()
        .withElementSpan().withComponentLabel().withChild()
        .withElementSpan().withComponentLabel().withSubComponentContent().withChild()
        .withElementSpan().withComponentLabel().withSubComponentText()
        .build();

    public static final String TPS_TABLE = new CssBuilder(CssSelectors.PAGES_CONTENT)
        .withChild()
        .withElementDiv().withComponentPage().withSubComponentMainBody().withChild()
        .withElementDiv().withChild()
        .withElementDiv().withChild()
        .withElementTable().withComponentTable()
        .build();

    public static final String TPS_TABLE_HEADER_ITEMS = new CssBuilder(TPS_TABLE)
        .withChild()
        .withElementThead().withComponentTable().withSubComponentThead().withChild()
        .withElementTr().withComponentTable().withSubComponentTr().withChild()
        .withElementTh().withComponentTable().withSubComponentTh()
        .build();

    public static final String TPS_TABLE_HEADER_SORT_BY_NAME = new CssBuilder(TPS_TABLE_HEADER_ITEMS)
        .nth(1)
        .build();

    public static final String TPS_TABLE_HEADER_SORT_BY_NAME_BUTTON = new CssBuilder(TPS_TABLE_HEADER_SORT_BY_NAME)
        .withChild()
        .withElementButton().withComponentTable().withSubComponentButton()
        .build();

    public static final String TPS_TABLE_HEADER_SORT_BY_STORAGE = new CssBuilder(TPS_TABLE_HEADER_ITEMS)
        .nth(5)
        .build();

    public static final String TPS_TABLE_HEADER_SORT_BY_STORAGE_BUTTON = new CssBuilder(TPS_TABLE_HEADER_SORT_BY_STORAGE)
        .withChild()
        .withElementButton().withComponentTable().withSubComponentButton()
        .build();

    public static final String TPS_TABLE_ROWS = new CssBuilder(TPS_TABLE)
        .withChild()
        .withElementTbody().withComponentTable().withSubComponentTbody()
        .build();

    public static final String TPS_TABLE_MANAGED_BADGE = new CssBuilder(TPS_TABLE_ROWS)
        .withChild()
        .withElementTr().withComponentTable().withSubComponentTr().withChild()
        .withElementTd().withComponentTable().withSubComponentTr().withChild()
        .withElementDiv().withChild()
        .withElementSpan()
        .build();

    public static String getTableRowItems(int nth) {
        return CssBuilder.joinLocators(new CssBuilder(TPS_TABLE_ROWS).nth(nth).build(), CssSelectors.PAGES_AD_TABLE_ROW_ITEMS);
    }

    public static String getTableRowItem(int nthRow, int nthColumn) {
        return new CssBuilder(getTableRowItems(nthRow)).nth(nthColumn).build();
    }

    public static final String TPS_TOP_TOOLBAR = new CssBuilder(CssSelectors.PAGES_CONTENT)
        .withChild()
        .withElementDiv().withComponentPage().withSubComponentMainBody().withChild()
        .withElementDiv().withChild()
        .withElementDiv().withComponentToolbar().withChild()
        .withElementDiv().withComponentToolbar().withSubComponentContent().nth(1)
        .build();

    public static final String TPS_TOP_TOOLBAR_SEARCH_CLEAR_ALL_FILTERS = new CssBuilder(CssSelectors.PAGES_CONTENT)
        .withChild()
        .withElementDiv().withComponentPage().withSubComponentMainBody().withChild()
        .withElementDiv().withChild()
        .withElementDiv().withComponentToolbar().withChild()
        .withElementDiv().withComponentToolbar().withSubComponentContent().nth(2).withChild()
        .withElementDiv().withComponentToolbar().withSubComponentGroup().nth(2).withChild()
        .withElementDiv().withComponentToolbar().withSubComponentItem().withChild()
        .withElementButton().withComponentButton()
        .build();

    public static final String TPS_TOP_TOOLBAR_SEARCH_CURRENT_STATUS_ITEMS = new CssBuilder(CssSelectors.PAGES_CONTENT)
        .withChild()
        .withElementDiv().withComponentPage().withSubComponentMainBody().withChild()
        .withElementDiv().withChild()
        .withElementDiv().withComponentToolbar().withChild()
        .withElementDiv().withComponentToolbar().withSubComponentContent().nth(2).withChild()
        .withElementDiv().withComponentToolbar().withSubComponentGroup().nth(1).withChild()
        .withElementDiv().withComponentToolbar().withSubComponentItem().withChild()
        .withElementDiv().withComponentLabelGroup().withChild()
        .withElementDiv().withComponentLabelGroup().withSubComponentMain().withChild()
        .withElementUl().withComponentLabelGroup().withSubComponentList().withChild()
        .withElementLi().withComponentLabelGroup().withSubComponentListItem()
        .build();

    public static final String TPS_TOP_TOOLBAR_FILTER = new CssBuilder(TPS_TOP_TOOLBAR)
        .withChild()
        .withElementDiv().withComponentToolbar().withSubComponentContentSection().withChild()
        .withElementDiv().withComponentToolbar().withSubComponentItem().nth(2).withChild()
        .withElementDiv().withComponentInputGroup()
        .build();

    public static final String TPS_TOP_TOOLBAR_FILTER_TYPE_DROPDOWN = new CssBuilder(TPS_TOP_TOOLBAR_FILTER)
        .withChild()
        .withElementButton().withComponentMenuToggle().nth(1)
        .build();
    public static final String TPS_TOP_TOOLBAR_FILTER_TYPE_DROPDOWN_ITEMS = new CssBuilder(TPS_TOP_TOOLBAR_FILTER)
        .withElementDiv().withComponentMenu().withChild()
        .withElementDiv().withComponentMenu().withSubComponentContent().withChild()
        .withElementUl().withComponentMenu().withSubComponentList().withChild()
        .withElementLi().withComponentMenu().withSubComponentListItem()
        .build();

    public static final String TPS_TOP_TOOLBAR_FILTER_SEARCH = new CssBuilder(TPS_TOP_TOOLBAR_FILTER)
        .withChild()
        .withElementDiv().withComponentInputGroup().withChild()
        .withElementSpan().withComponentFormControl().withChild()
        .withElementInput()
        .build();

    public static final String TPS_TOP_TOOLBAR_FILTER_SEARCH_BUTTON = new CssBuilder(TPS_TOP_TOOLBAR_FILTER)
        .withChild()
        .withElementDiv().withComponentInputGroup().withChild()
        .withElementButton().withComponentButton()
        .build();

    public static final String TPS_TOP_TOOLBAR_FILTER_BY_STATUS_DROPDOWN = new CssBuilder(TPS_TOP_TOOLBAR_FILTER)
        .withChild()
        .withElementButton().withComponentMenuToggle().nth(2)
        .build();

    public static final String TPS_TOP_TOOLBAR_FILTER_BY_STATUS_DROPDOWN_ITEMS = new CssBuilder(TPS_TOP_TOOLBAR_FILTER)
        .withElementDiv().withComponentMenu().withChild()
        .withElementDiv().withComponentMenu().withSubComponentContent().withChild()
        .withElementUl().withComponentMenu().withSubComponentList().withChild()
        .withElementLi().withComponentMenu().withSubComponentListItem()
        .build();

    public static final String TPS_TOP_TOOLBAR_FILTER_BY_STATUS_FULLY_REPLICATED = new CssBuilder(TPS_TOP_TOOLBAR_FILTER_BY_STATUS_DROPDOWN_ITEMS)
        .nth(1)
        .build();

    public static final String TPS_TOP_TOOLBAR_FILTER_BY_STATUS_UNDER_REPLICATED = new CssBuilder(TPS_TOP_TOOLBAR_FILTER_BY_STATUS_DROPDOWN_ITEMS)
        .nth(2)
        .build();

    public static final String TPS_TOP_TOOLBAR_FILTER_BY_STATUS_OFFLINE = new CssBuilder(TPS_TOP_TOOLBAR_FILTER_BY_STATUS_DROPDOWN_ITEMS)
        .nth(5)
        .build();

    public static final String TPS_TOP_PAGINATION_DROPDOWN_BUTTON = new CssBuilder(TPS_TOP_TOOLBAR)
        .withChild()
        .withElementDiv().withComponentToolbar().withSubComponentContentSection().withChild()
        .withElementDiv().withComponentToolbar().withSubComponentGroup().withChild()
        .withElementDiv().withComponentPagination().withChild()
        .withElementDiv().withComponentPagination().withSubComponentPageMenu().withChild()
        .withElementButton().withComponentMenuToggle()
        .build();

    public static final String TPS_TOP_PAGINATION_DROPDOWN_BUTTON_TEXT = new CssBuilder(TPS_TOP_PAGINATION_DROPDOWN_BUTTON)
        .withChild()
        .withElementSpan().withComponentMenuToggle().withSubComponentText()
        .build();

    public static final String TPS_PAGINATION_DROPDOWN_ITEMS = new CssBuilder()
        .withElementBody().withDesc()
        .withElementDiv().withComponentMenu().withChild()
        .withElementDiv().withComponentMenu().withSubComponentContent().withChild()
        .withElementUl().withComponentMenu().withSubComponentList().withChild()
        .withElementLi().withComponentMenu().withSubComponentListItem()
        .build();

    public static final String TPS_TOP_PAGINATION_NAV_BUTTONS = new CssBuilder(TPS_TOP_TOOLBAR)
        .withChild()
        .withElementDiv().withComponentToolbar().withSubComponentContentSection().withChild()
        .withElementDiv().withComponentToolbar().withSubComponentGroup().withChild()
        .withElementDiv().withComponentPagination().withChild()
        .withElementNav().withComponentPagination().withSubComponentNav()
        .build();

    public static final String TPS_TOP_PAGINATION_NAV_PREV_BUTTON = new CssBuilder(TPS_TOP_PAGINATION_NAV_BUTTONS)
        .withChild()
        .withElementDiv().withComponentPagination().withSubComponentNavControl().nth(1)
        .build();

    public static final String TPS_TOP_PAGINATION_NAV_NEXT_BUTTON = new CssBuilder(TPS_TOP_PAGINATION_NAV_BUTTONS)
        .withChild()
        .withElementDiv().withComponentPagination().withSubComponentNavControl().nth(2)
        .build();

    public static final String TPS_BOTTOM_TOOLBAR = new CssBuilder(CssSelectors.PAGES_CONTENT)
        .withChild()
        .withElementDiv().withComponentPage().withSubComponentMainBody().withChild()
        .withElementDiv().withChild()
        .withElementDiv().withComponentPagination()
        .build();

    public static final String TPS_BOTTOM_PAGINATION_DROPDOWN_BUTTON = new CssBuilder(TPS_BOTTOM_TOOLBAR)
        .withChild()
        .withElementDiv().withComponentPagination().withSubComponentPageMenu().withChild()
        .withElementButton().withComponentMenuToggle()
        .build();

    public static final String TPS_BOTTOM_PAGINATION_DROPDOWN_BUTTON_TEXT = new CssBuilder(TPS_BOTTOM_PAGINATION_DROPDOWN_BUTTON)
        .withChild()
        .withElementSpan().withComponentMenuToggle().withSubComponentText()
        .build();

    public static final String TPS_BOTTOM_PAGINATION_NAV_BUTTONS = new CssBuilder(TPS_BOTTOM_TOOLBAR)
        .withChild()
        .withElementNav().withComponentPagination().withSubComponentNav()
        .build();

    public static final String TPS_BOTTOM_PAGINATION_NAV_PREV_BUTTON = new CssBuilder(TPS_BOTTOM_PAGINATION_NAV_BUTTONS)
        .withChild()
        .withElementDiv().withComponentPagination().withSubComponentNavControl().nth(1)
        .build();

    public static final String TPS_BOTTOM_PAGINATION_NAV_NEXT_BUTTON = new CssBuilder(TPS_BOTTOM_PAGINATION_NAV_BUTTONS)
        .withChild()
        .withElementDiv().withComponentPagination().withSubComponentNavControl().nth(2)
        .build();

    // Create topic selectors
    public static final String TPS_CREATE_TOPIC_PAGE = new CssBuilder(CssSelectors.PAGES_MAIN_CONTENT)
        .withChild()
        .withElementDiv().withComponentWizard().withChild()
        .withElementDiv().withComponentWizard().withSubComponentOuterWrap().withChild()
        .withElementDiv().withComponentWizard().withSubComponentInnerWrap().withChild()
        .withElementDiv().withComponentWizard().withSubComponentMain().withChild()
        .withElementDiv().withComponentWizard().withSubComponentMainBody()
        .build();

    public static final String TPS_CREATE_TOPIC_FORM = new CssBuilder(TPS_CREATE_TOPIC_PAGE)
        .withChild()
        .withElementForm().withComponentForm()
        .build();

    public static final String TPS_CREATE_TOPIC_OPTION_TABLE = new CssBuilder(TPS_CREATE_TOPIC_PAGE)
        .withChild()
        .withElementTable().withComponentTable()
        .build();

    public static final String TPS_CREATE_TOPIC_NAME_INPUT  = new CssBuilder(TPS_CREATE_TOPIC_FORM)
        .withChild()
        .withElementSection().withComponentForm().withSubComponentSection().nth(1).withChild()
        .withElementDiv().withComponentForm().withSubComponentGroup().withChild()
        .withElementDiv().withComponentForm().withSubComponentGroupControl().withChild()
        .withElementSpan().withComponentFormControl().withChild()
        .withElementInput()
        .build();

    public static final String TPS_CREATE_TOPIC_PARTITIONS_INPUT = new CssBuilder(TPS_CREATE_TOPIC_FORM)
        .withChild()
        .withElementSection().withComponentForm().withSubComponentSection().nth(2).withChild()
        .withElementDiv().withComponentForm().withSubComponentGroup().withChild()
        .withElementDiv().withComponentForm().withSubComponentGroupControl().withChild()
        .withElementDiv().withComponentNumberInput().withChild()
        .withElementDiv().withComponentInputGroup().withChild()
        .withElementDiv().withComponentInputGroup().withSubComponentItem().nth(2).withChild()
        .withElementSpan().withComponentFormControl().withChild()
        .withElementInput()
        .build();

    public static final String TPS_CREATE_TOPIC_REPLICAS_INPUT = new CssBuilder(TPS_CREATE_TOPIC_FORM)
        .withChild()
        .withElementSection().withComponentForm().withSubComponentSection().nth(3).withChild()
        .withElementDiv().withComponentForm().withSubComponentGroup().withChild()
        .withElementDiv().withComponentForm().withSubComponentGroupControl().withChild()
        .withElementDiv().withComponentNumberInput().withChild()
        .withElementDiv().withComponentInputGroup().withChild()
        .withElementDiv().withComponentInputGroup().withSubComponentItem().nth(2).withChild()
        .withElementSpan().withComponentFormControl().withChild()
        .withElementInput()
        .build();

    public static final String TPS_CREATE_TOPIC_REVIEW_AND_FINISH_BUTTON = new CssBuilder(CssSelectors.PAGES_MAIN_CONTENT)
        .withChild()
        .withElementDiv().withComponentWizard().withChild()
        .withElementDiv().withComponentWizard().withSubComponentOuterWrap().withChild()
        .withElementFooter().withComponentWizard().withSubComponentFooter().withChild()
        .withElementButton().withComponentButton().nth(3).withChild()
        .withElementSpan().withComponentButton().withSubComponentText()
        .build();


    public static final String TPS_CREATE_TOPIC_NEXT_BUTTON = new CssBuilder(CssSelectors.PAGES_MAIN_CONTENT)
        .withChild()
        .withElementDiv().withComponentWizard().withChild()
        .withElementDiv().withComponentWizard().withSubComponentOuterWrap().withChild()
        .withElementFooter().withComponentWizard().withSubComponentFooter().withChild()
        .withElementButton().withComponentButton().nth(2).withChild()
        .withElementSpan().withComponentButton().withSubComponentText()
        .build();


    public static final String TPS_CREATE_TOPIC_OPTION_FLUSH_MS_INPUT = new CssBuilder(CssSelectors.PAGES_MAIN_CONTENT)
        .withChild()
        .withElementDiv().withComponentWizard().withChild()
        .withElementDiv().withComponentWizard().withSubComponentOuterWrap().withChild()
        .withElementDiv().withComponentWizard().withSubComponentInnerWrap().withChild()
        .withElementDiv().withComponentWizard().withSubComponentMain().withChild()
        .withElementDiv().withComponentWizard().withSubComponentMainBody().withChild()
        .withElementTable().withComponentTable().withChild()
        .withElementTbody().withComponentTable().withSubComponentTbody().nth(7).withChild()
        .withElementTr().withComponentTable().withSubComponentTr().withChild()
        .withElementTd().withComponentTable().withSubComponentTd().nth(2).withChild()
        .withElementDiv().withComponentForm().withSubComponentGroup().withChild()
        .withElementDiv().withComponentForm().withSubComponentGroupControl().withChild()
        .withElementSpan().withComponentFormControl().withChild()
        .withElementInput()
        .build();

    public static final String TPS_CREATE_TOPIC_OPTION_MIN_ISR_INPUT = new CssBuilder(TPS_CREATE_TOPIC_OPTION_TABLE)
        .withChild()
        .withElementTbody().withComponentTable().withSubComponentTbody().nth(4).withChild()
        .withElementTr().withComponentTable().withSubComponentTr().withChild()
        .withElementTd().withComponentTable().withSubComponentTd().nth(2).withChild()
        .withElementDiv().withComponentForm().withSubComponentGroup().withChild()
        .withElementDiv().withComponentForm().withSubComponentGroupControl().withChild()
        .withElementSpan().withComponentFormControl().withChild()
        .withElementInput()
        .build();

    public static String getTopicRowOptionButton(int nthRow) {
        return new CssBuilder(getTableRowItems(nthRow))
            .withChild()
            .withElementButton().withComponentMenuToggle()
        .build();
    }

    public static final String TPS_EDIT_TOPIC_BUTTON = new CssBuilder(CssSelectors.PAGES_CONTENT)
        .withChild()
        .withElementDiv().withComponentPage().withSubComponentMainBody().withChild()
        .withElementDiv().withComponentScrollOuterWrapper().withChild()
        .withElementDiv().withComponentMenu().withChild()
        .withElementDiv().withComponentMenu().withSubComponentContent().withChild()
        .withElementUl().withComponentMenu().withSubComponentList().withChild()
        .withElementLi().withComponentMenu().withSubComponentListItem().nth(1).withChild()
        .withElementButton().withComponentMenu().withSubComponentItem()
        .build();

    public static final String TPS_DELETE_TOPIC_BUTTON = new CssBuilder(CssSelectors.PAGES_CONTENT)
        .withChild()
        .withElementDiv().withComponentPage().withSubComponentMainBody().withChild()
        .withElementDiv().withComponentScrollOuterWrapper().withChild()
        .withElementDiv().withComponentMenu().withChild()
        .withElementDiv().withComponentMenu().withSubComponentContent().withChild()
        .withElementUl().withComponentMenu().withSubComponentList().withChild()
        .withElementLi().withComponentMenu().withSubComponentListItem().nth(2).withChild()
        .withElementButton().withComponentMenu().withSubComponentItem()
        .build();


    public static final String TPS_DELETE_TOPIC_MODAL_TITLE = new CssBuilder(CssSelectors.PAGES_POPUP_MODAL_HEADER)
        .withChild()
        .withElementH1().withComponentModalBox().withSubComponentTitle().withChild()
        .withElementSpan().withComponentModalBox().withSubComponentTitleText()
        .build();


    public static final String TPS_DELETE_TOPIC_MODAL_INPUT_NAME = new CssBuilder(CssSelectors.PAGES_POPUP_MODAL_BODY)
        .withChild()
        .withChild()
        .withElementForm().withComponentForm().withChild()
        .withElementDiv().withComponentForm().withSubComponentGroup().withChild()
        .withElementDiv().withComponentForm().withSubComponentGroupControl().withChild()
        .withElementSpan().withComponentFormControl().withChild()
        .withElementInput()
        .build();

    public static final String TPS_CONFIRM_MODAL_DELETE_TOPIC_BUTTON = new CssBuilder(CssSelectors.PAGES_MODAL_CONFIRM_BUTTON)
        .withChild()
        .withElementSpan().withComponentButton().withSubComponentText()
        .build();


    // Edit page
    public static final String TPS_TOPIC_OPTION_TABLE = new CssBuilder(CssSelectors.PAGES_CONTENT)
        .withChild()
        .withElementDiv().withComponentPage().withSubComponentMainBody().withChild()
        .withElementDiv().withComponentScrollOuterWrapper().withChild()
        .withElementDiv().withComponentScrollInnerWrapper().withChild()
        .withElementTable().withComponentTable().withChild()
        .withElementTbody().withComponentTable().withSubComponentTbody()
        .build();

    public static String getTopicRowEditButton(int nthRow) {
        return CssBuilder.joinLocators(new CssBuilder(TPS_TOPIC_OPTION_TABLE).nth(nthRow).withChild().build(),
            TPS_TOPIC_OPTION_TABLE_EDIT_BUTTON_AD);
    }

    public static final String TPS_TOPIC_OPTION_TABLE_EDIT_BUTTON_AD = new CssBuilder()
        .withElementTr().withComponentTable().withSubComponentTr().withChild()
        .withElementTd().withComponentTable().withSubComponentTd().nth(3).withChild()
        .withElementButton().withComponentButton()
        .build();

    public static final String TPS_TOPIC_OPTION_TABLE_EDIT_CONFIRM_AD = new CssBuilder(TPS_TOPIC_OPTION_TABLE)
        .withChild()
        .withElementTr().withComponentTable().withSubComponentTr().withChild()
        .withElementTd().withComponentTable().withSubComponentTd().nth(3).withChild()
        .withElementDiv().withComponentInlineEdit().withChild()
        .withElementDiv().withComponentInlineEdit().withSubComponentGroup().withChild()
        .withElementDiv().withComponentInlineEdit().withSubComponentAction().nth(1).withChild()
        .withElementButton().withComponentButton()
        .build();

    public static final String TPS_TOPIC_OPTION_TABLE_EDIT_INPUT = new CssBuilder(TPS_TOPIC_OPTION_TABLE)
        .withChild()
        .withElementTr().withComponentTable().withSubComponentTr().withChild()
        .withElementTd().withComponentTable().withSubComponentTd().nth(2).withChild()
        .withElementDiv().withComponentForm().withSubComponentGroup().withChild()
        .withElementDiv().withComponentForm().withSubComponentGroupControl().withChild()
        .withElementSpan().withComponentFormControl().withChild()
        .withElementInput()
        .build();
}
