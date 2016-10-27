package steps.accounts;

import com.tests.pages.ClientDetailPage;
import com.tests.pages.ClientPage;
import com.tests.pages.HomePage;
import com.thoughtworks.gauge.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ClientSteps {
    @Step("Search for client <searchTerm>")
    public void searchClient(String searchTerm) throws InterruptedException {
        assertThat("Home page is ready", new HomePage().isReady(), is(true));
        new HomePage()
                .openClients()
                .search(searchTerm);
        assertThat(searchTerm + " is displayed in table", new ClientPage().isTableContains(searchTerm), is(true));
    }

    @Step("Select client")
    public void selectClient() throws InterruptedException {
        assertThat("Client page is ready", new ClientPage().isReady(), is(true));
        new ClientPage().selectClient();
        assertThat("Client detail page is ready", new ClientDetailPage().isReady());
    }
}
