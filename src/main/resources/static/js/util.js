function removeTrialingProjection(string) {
    return string.replace(/\{\?projection\}/, "");
}