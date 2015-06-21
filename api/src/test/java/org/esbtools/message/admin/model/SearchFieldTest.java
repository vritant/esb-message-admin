
package org.esbtools.message.admin.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SearchFieldTest {

    @Test
    public void testGetValueTypeTrue() {
        assertEquals(SearchField.valueOf("esbMessageType").getValueType(), String.class);
    }

    @Test
    public void testNotPreDefined() {
        assertFalse(SearchField.isPreDefined("customfield"));
    }
    
    @Test
    public void testIsPreDefined() {
        assertTrue(SearchField.isPreDefined("id"));
        assertTrue(SearchField.isPreDefined("esbErrorQueue"));
        assertTrue(SearchField.isPreDefined("esbMessageId"));
        assertTrue(SearchField.isPreDefined("esbMessageGuid"));
        assertTrue(SearchField.isPreDefined("esbMessageType"));
        assertTrue(SearchField.isPreDefined("esbSourceQueue"));
        assertTrue(SearchField.isPreDefined("esbSourceSystem"));
        assertTrue(SearchField.isPreDefined("esbOriginalSystem"));
        assertTrue(SearchField.isPreDefined("esbQueueName"));
        assertTrue(SearchField.isPreDefined("esbQueueLocation"));
        assertTrue(SearchField.isPreDefined("esbErrorComponent"));
        assertTrue(SearchField.isPreDefined("esbServiceName"));
        assertTrue(SearchField.isPreDefined("customHeader"));
    }
    
    @Test
    public void testIsPreDefinedUpperCase() {
        assertTrue(SearchField.isPreDefined("ID"));
        assertTrue(SearchField.isPreDefined("ESBERRORQUEUE"));
        assertTrue(SearchField.isPreDefined("ESBMESSAGEID"));
        assertTrue(SearchField.isPreDefined("ESBMESSAGEGUID"));
        assertTrue(SearchField.isPreDefined("ESBMESSAGETYPE"));
        assertTrue(SearchField.isPreDefined("ESBSOURCEQUEUE"));
        assertTrue(SearchField.isPreDefined("ESBSOURCESYSTEM"));
        assertTrue(SearchField.isPreDefined("ESBORIGINALSYSTEM"));
        assertTrue(SearchField.isPreDefined("ESBQUEUENAME"));
        assertTrue(SearchField.isPreDefined("ESBQUEUELOCATION"));
        assertTrue(SearchField.isPreDefined("ESBERRORCOMPONENT"));
        assertTrue(SearchField.isPreDefined("ESBSERVICENAME"));
        assertTrue(SearchField.isPreDefined("CUSTOMHEADER"));
    }

    @Test
    public void testIsPreDefinedLowerCase() {
        assertTrue(SearchField.isPreDefined("id"));
        assertTrue(SearchField.isPreDefined("esberrorqueue"));
        assertTrue(SearchField.isPreDefined("esbmessageid"));
        assertTrue(SearchField.isPreDefined("esbmessageguid"));
        assertTrue(SearchField.isPreDefined("esbmessagetype"));
        assertTrue(SearchField.isPreDefined("esbsourcequeue"));
        assertTrue(SearchField.isPreDefined("esbsourcesystem"));
        assertTrue(SearchField.isPreDefined("esboriginalsystem"));
        assertTrue(SearchField.isPreDefined("esbqueuename"));
        assertTrue(SearchField.isPreDefined("esbqueuelocation"));
        assertTrue(SearchField.isPreDefined("esberrorcomponent"));
        assertTrue(SearchField.isPreDefined("esbservicename"));
        assertTrue(SearchField.isPreDefined("customheader"));
    }
    
    @Test
    public void testMatch() {
        SearchField matchResult = SearchField.match("esbmessageid");
        assertEquals(SearchField.esbMessageId, matchResult);
    }

}
