package com.digitalpetri.opcua.stack.core.types.structured;

import com.digitalpetri.opcua.stack.core.Identifiers;
import com.digitalpetri.opcua.stack.core.serialization.DelegateRegistry;
import com.digitalpetri.opcua.stack.core.serialization.UaDecoder;
import com.digitalpetri.opcua.stack.core.serialization.UaEncoder;
import com.digitalpetri.opcua.stack.core.serialization.UaRequestMessage;
import com.digitalpetri.opcua.stack.core.types.UaDataType;
import com.digitalpetri.opcua.stack.core.types.builtin.NodeId;

@UaDataType("DeleteReferencesRequest")
public class DeleteReferencesRequest implements UaRequestMessage {

    public static final NodeId TypeId = Identifiers.DeleteReferencesRequest;
    public static final NodeId BinaryEncodingId = Identifiers.DeleteReferencesRequest_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.DeleteReferencesRequest_Encoding_DefaultXml;

    protected final RequestHeader _requestHeader;
    protected final DeleteReferencesItem[] _referencesToDelete;

    public DeleteReferencesRequest() {
        this._requestHeader = null;
        this._referencesToDelete = null;
    }

    public DeleteReferencesRequest(RequestHeader _requestHeader, DeleteReferencesItem[] _referencesToDelete) {
        this._requestHeader = _requestHeader;
        this._referencesToDelete = _referencesToDelete;
    }

    public RequestHeader getRequestHeader() {
        return _requestHeader;
    }

    public DeleteReferencesItem[] getReferencesToDelete() {
        return _referencesToDelete;
    }

    @Override
    public NodeId getTypeId() {
        return TypeId;
    }

    @Override
    public NodeId getBinaryEncodingId() {
        return BinaryEncodingId;
    }

    @Override
    public NodeId getXmlEncodingId() {
        return XmlEncodingId;
    }


    public static void encode(DeleteReferencesRequest deleteReferencesRequest, UaEncoder encoder) {
        encoder.encodeSerializable("RequestHeader", deleteReferencesRequest._requestHeader != null ? deleteReferencesRequest._requestHeader : new RequestHeader());
        encoder.encodeArray("ReferencesToDelete", deleteReferencesRequest._referencesToDelete, encoder::encodeSerializable);
    }

    public static DeleteReferencesRequest decode(UaDecoder decoder) {
        RequestHeader _requestHeader = decoder.decodeSerializable("RequestHeader", RequestHeader.class);
        DeleteReferencesItem[] _referencesToDelete = decoder.decodeArray("ReferencesToDelete", decoder::decodeSerializable, DeleteReferencesItem.class);

        return new DeleteReferencesRequest(_requestHeader, _referencesToDelete);
    }

    static {
        DelegateRegistry.registerEncoder(DeleteReferencesRequest::encode, DeleteReferencesRequest.class, BinaryEncodingId, XmlEncodingId);
        DelegateRegistry.registerDecoder(DeleteReferencesRequest::decode, DeleteReferencesRequest.class, BinaryEncodingId, XmlEncodingId);
    }

}
