package utils;

import exception.ApplicationException;
import sorter.SortOrder;
import sorter.ContentFileType;

public class SorterSettings {
    private SortOrder sortOrder;
    private ContentFileType type;
    private String outPrefix;

    public SortOrder getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    public ContentFileType getType() {
        return type;
    }

    public void setType(ContentFileType type) {
        this.type = type;
    }

    public String getOutPrefix() {
        return outPrefix;
    }

    public void setOutPrefix(String outPrefix) {
        this.outPrefix = outPrefix;
    }

    public static class SorterSettingBuilder implements Builder<SorterSettings> {
        private SortOrder builderSortOrder;
        private ContentFileType builderType;
        private String builderOutPrefix;

        @Override
        public SorterSettings build() {
            return constructSorterSettings();
        }

        public SorterSettingBuilder setBuilderSortOrder(String sortOrderCode) throws ApplicationException {
            this.builderSortOrder = SortOrder.getSortOrderByCode(sortOrderCode);

            return this;
        }

        public SorterSettingBuilder setBuilderType(String typeCode) throws ApplicationException {
            this.builderType = ContentFileType.getTypeByCode(typeCode);

            return this;
        }

        public SorterSettingBuilder setBuilderOutPrefix(String builderOutPrefix) throws ApplicationException {
            if (builderOutPrefix == null) {
                throw new ApplicationException("Output file prefix not specified");
            }
            this.builderOutPrefix = builderOutPrefix;

            return this;
        }

        private SorterSettings constructSorterSettings() {
            SorterSettings sorterSettings = new SorterSettings();

            sorterSettings.setSortOrder(builderSortOrder);
            sorterSettings.setType(builderType);
            sorterSettings.setOutPrefix(builderOutPrefix);

            return sorterSettings;
        }
    }
}
