package org.kohsuke.github;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * Asset in a release.
 *
 * @see GHRelease#getAssets() GHRelease#getAssets()
 */
public class GHAsset extends GHObject {

    /**
     * Wrap gh asset [ ].
     *
     * @param assets
     *            the assets
     * @param release
     *            the release
     * @return the gh asset [ ]
     */
    public static GHAsset[] wrap(GHAsset[] assets, GHRelease release) {
        for (GHAsset aTo : assets) {
            aTo.wrap(release);
        }
        return assets;
    }

    private String browserDownloadUrl;
    private String contentType;
    private String digest;
    private long downloadCount;
    private String label;
    private String name;
    private long size;
    private String state;
    /** The owner. */
    GHRepository owner;

    /**
     * Create default GHAsset instance
     */
    public GHAsset() {
    }

    /**
     * Delete.
     *
     * @throws IOException
     *             the io exception
     */
    public void delete() throws IOException {
        root().createRequest().method("DELETE").withUrlPath(getApiRoute()).send();
    }

    /**
     * Gets browser download url.
     *
     * @return the browser download url
     */
    public String getBrowserDownloadUrl() {
        return browserDownloadUrl;
    }

    /**
     * Gets content type.
     *
     * @return the content type
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Gets digest.
     *
     * @return the digest
     */
    public String getDigest() {
        return digest;
    }

    /**
     * Gets download count.
     *
     * @return the download count
     */
    public long getDownloadCount() {
        return downloadCount;
    }

    /**
     * Gets label.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets owner.
     *
     * @return the owner
     */
    @SuppressFBWarnings(value = { "EI_EXPOSE_REP" }, justification = "Expected behavior")
    public GHRepository getOwner() {
        return owner;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public long getSize() {
        return size;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets content type.
     *
     * @param contentType
     *            the content type
     * @throws IOException
     *             the io exception
     */
    public void setContentType(String contentType) throws IOException {
        edit("content_type", contentType);
        this.contentType = contentType;
    }

    /**
     * Sets label.
     *
     * @param label
     *            the label
     * @throws IOException
     *             the io exception
     */
    public void setLabel(String label) throws IOException {
        edit("label", label);
        this.label = label;
    }

    private void edit(String key, Object value) throws IOException {
        root().createRequest().with(key, value).method("PATCH").withUrlPath(getApiRoute()).send();
    }

    private String getApiRoute() {
        return "/repos/" + owner.getOwnerName() + "/" + owner.getName() + "/releases/assets/" + getId();
    }

    /**
     * Wrap.
     *
     * @param release
     *            the release
     * @return the GH asset
     */
    GHAsset wrap(GHRelease release) {
        this.owner = release.getOwner();
        return this;
    }
}
